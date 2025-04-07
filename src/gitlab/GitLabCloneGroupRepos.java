package gitlab;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitLabCloneGroupRepos {

    private static String GITLAB_API_URL = ""; // "https://gitlab.com/api/v4";
    private static String ACCESS_TOKEN = ""; // 替换成你自己的
    private static String CLONE_DIR = ""; // 下载目录

    public static void main(String[] args) throws Exception {
        String GITLAB_API_URL_FORMAT = "https://%s/api/v4";
        GITLAB_API_URL = String.format(GITLAB_API_URL_FORMAT, args[0]);
        ACCESS_TOKEN = args[1];
        // 替换成目标 group
        String GROUP_NAME = args[2];
        CLONE_DIR = args[3] + "/" + GROUP_NAME;
        int groupId = getGroupIdByName(GROUP_NAME);
        downloadReposInGroup(groupId);
    }

    // 通过 group name 查询 group id
    public static int getGroupIdByName(String groupName) throws Exception {
        String url = GITLAB_API_URL + "/groups?search=" + groupName;
        JSONArray groups = getJsonArrayFromUrl(url);
        if (groups.length() == 0) throw new RuntimeException("Group not found");
        return groups.getJSONObject(0).getInt("id");
    }

    // 获取 group 下所有项目并 clone
    public static void downloadReposInGroup(int groupId) throws Exception {
        int page = 1;
        int perPage = 100;
        boolean hasMore = true;
        while (hasMore) {
            String url = GITLAB_API_URL + "/groups/" + groupId + "/projects?page=" + page + "&per_page=" + perPage;
            JSONArray projects = getJsonArrayFromUrl(url);

            if (projects.length() == 0) break;

            for (int i = 0; i < projects.length(); i++) {
                JSONObject project = projects.getJSONObject(i);
                String name = project.getString("name");
                String cloneUrl = project.getString("ssh_url_to_repo");

                System.out.println("Cloning " + name + " from " + cloneUrl);
                cloneRepo(cloneUrl, name);
            }
            page++;
        }
    }

    // GET 请求并解析 JSON
    private static JSONArray getJsonArrayFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("PRIVATE-TOKEN", ACCESS_TOKEN);
        conn.setRequestProperty("User-Agent", "GitLab Java Downloader");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return new JSONArray(response.toString());
    }

    // 使用 git clone 克隆仓库
    private static void cloneRepo(String cloneUrl, String repoName) {
        try {
            ProcessBuilder pb = new ProcessBuilder("git", "clone", cloneUrl, CLONE_DIR + "/" + repoName);
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            System.err.println("Clone failed for " + repoName + ": " + e.getMessage());
        }
    }
}
