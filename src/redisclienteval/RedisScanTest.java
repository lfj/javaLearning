package redisclienteval;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.redisson.codec.IonJacksonCodec;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class RedisScanTest {

    public static Statement getStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接
            String url = "jdbc:mysql://snscirclero.db2.sohuno.com:3306/sns_circle?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&autoReconnect=true&serverTimezone=Asia/Shanghai&useAffectedRows=true";
            String username = "sns_circle_ro";
            String password = "6636Spi7bX6y9Ex";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRedis(Jedis jedis1, Jedis jedis2, Jedis jedis3, Jedis jedis4, String activityId) {
        String s = jedis1.get("sc:26:ac:04:" + activityId);
        if (null == s) {
            s = jedis2.get("sc:26:ac:04:" + activityId);
        }
        if (null == s) {
            s = jedis3.get("sc:26:ac:04:" + activityId);
        }
        s = jedis4.get("sc:26:ac:04:" + activityId);
        return s;
    }

    public static void main(String[] args) throws Exception{
        Statement statement = getStatement();
        Jedis jedis1 = new Jedis("ma.zw.redis.sohucs.com", 22111);
        jedis1.auth("f1bc39a50c2d434e932cd1659358ea25");

        Jedis jedis2 = new Jedis("ma.zw.redis.sohucs.com", 22105);
        jedis2.auth("3fb72e6c955b42cab4525e2eab08cab8");

        Jedis jedis3 = new Jedis("ma.zw.redis.sohucs.com", 22112);
        jedis3.auth("d9210c5ad7524b0289aef5782154485a");

        Jedis jedis4 = new Jedis("ma.zw.redis.sohucs.com", 22113);
        jedis4.auth("2db93ef3620643ef9bb7c7502cc939c9");

        String sql = "select id,activity_id,status,create_time_id from t_circle_new_activity " +
                "where id>%d limit 100";
        boolean flag = true;
        long score = 0L;
        int totalNum1 = 0;
        int totalNum2 = 0;
        while (flag) {
            sql = String.format(sql, score);
            ResultSet rs = statement.executeQuery(sql);
            if (rs.getFetchSize() < 100) {
                flag = false;
            }
            while (rs.next()) {
                // 通过字段检索
                String activityId  = rs.getString("activity_id");
                Integer status = rs.getInt("status");
                Long createTimeId = rs.getLong("create_time_id");
                String json = getRedis(jedis1, jedis2, jedis3, jedis4, activityId);
                if (null != json) {
                    Gson gson = new Gson();
                    Integer statusFromRedis;
                    Long createTimeIdFromRedis;
                    try {
                        CircleActivity circleActivity = gson.fromJson(json, CircleActivity.class);
                        statusFromRedis = circleActivity.getStatus().getCode();
                        createTimeIdFromRedis = circleActivity.getCreateTimeId();
                    } catch (Exception e) {
                        continue;
                    }
                    if (!Objects.equals(status, statusFromRedis)) {
                        System.out.println(activityId + "数据库和缓存不一致");
                        totalNum1 ++;
                    }
                    if (!Objects.equals(createTimeId, createTimeIdFromRedis)) {
                        System.out.println(activityId + "时间戳不一致");
                        totalNum2 ++;
                    }
                }
                score = rs.getLong("id");
            }
            rs.close();
        }

        Jedis jedis = new Jedis("mpt.zw.redis.sohucs.com", 22058);
        jedis.auth("d799347b61304dc0b930d3b6e9de8650");
        ScanParams scanParams = new ScanParams();
        //模糊匹配的redis的键
        scanParams.match("sc:26:ac:04:*");
        //每次查询的条数
        scanParams.count(1000);
        String scanStart = "0";
        int i = 0;
        int keyCount = 0;
        while (true) {
            i++;
            ScanResult<String> scan = jedis.scan(scanStart, scanParams);
            scanStart = scan.getStringCursor();
            if ("0".equals(scanStart)) {
                break;
            }
            List<String> resultList = scan.getResult();
            if (!resultList.isEmpty()) {
                resultList.forEach(e -> {
                    //jedis.get(e)
                    //System.out.println(e);
                    //Long del = jedis.del(e);
                });
                keyCount = keyCount + resultList.size();
            }
        }
        System.out.println("总共循环了" + i + "次！");
        System.out.println("总共扫瞄了" + keyCount + "个key！");
    }
}

