package gitlab;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GitLabStaleBranchCleaner {
    private static String GITLAB_URL = ""; // 修改为你的 GitLab 地址
    private static String PRIVATE_TOKEN = ""; // 你的 GitLab Token
    private static String PROJECT_ID = ""; // 你的项目 ID
    private static final int PER_PAGE = 100; // 每页获取 100 个分支

    public static void main(String[] args) throws Exception {
        GITLAB_URL = args[0];
        PRIVATE_TOKEN = args[1];
        PROJECT_ID = args[2];
        List<String> staleBranches = getStaleBranches();

        if (staleBranches.isEmpty()) {
            System.out.println("没有找到 stale 分支，无需删除。");
        } else {
            System.out.println("即将删除以下 stale 分支：" + staleBranches);
            for (String branch : staleBranches) {
                deleteBranch(branch);
                System.out.println("✅ 成功删除分支：" + branch);
            }
            System.out.println("所有 stale 分支已删除！");
        }
    }

    // 分页获取所有 stale 分支
    private static List<String> getStaleBranches() throws Exception {
        List<String> staleBranches = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Instant oneYearAgo = Instant.now().minusSeconds(90L * 24 * 60 * 60); // 计算 1 年前的时间

        int page = 1;
        while (true) {
            // 构造分页 URL
            URL url = new URL(GITLAB_URL + "/api/v4/projects/" + PROJECT_ID +
                    "/repository/branches?per_page=" + PER_PAGE + "&page=" + page);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("PRIVATE-TOKEN", PRIVATE_TOKEN);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("请求失败，错误代码：" + conn.getResponseCode());
            }

            // 读取 API 响应
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();
            conn.disconnect();

            // 解析 JSON 数据
            JsonNode branches = objectMapper.readTree(response.toString());
            if (branches.isEmpty()) break; // 没有更多数据，终止循环
            for (JsonNode branch : branches) {
                JsonNode commitNode = branch.get("commit");
                if (commitNode != null && commitNode.has("committed_date")) {
                    String commitDateStr = commitNode.get("committed_date").asText();
                    OffsetDateTime commitDate = OffsetDateTime.parse(commitDateStr);
                    Instant commitInstant = commitDate.toInstant();
                    if (commitInstant.isBefore(oneYearAgo)) { // 超过 1 年未更新
                        staleBranches.add(branch.get("name").asText());
                    }
                }
            }
            page++; // 下一页
        }
        return staleBranches;
    }

    // 删除指定 stale 分支
    private static void deleteBranch(String branchName) throws Exception {
        String encodedBranchName = branchName.replace("/", "%2F"); // 处理分支名包含斜杠
        URL url = new URL(GITLAB_URL + "/api/v4/projects/" + PROJECT_ID + "/repository/branches/" + encodedBranchName);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("PRIVATE-TOKEN", PRIVATE_TOKEN);

        if (conn.getResponseCode() == 204) {
            System.out.println("✅ 成功删除分支：" + branchName);
        } else {
            System.out.println("❌ 删除失败：" + branchName + "，错误代码：" + conn.getResponseCode());
        }
        conn.disconnect();
    }
}
