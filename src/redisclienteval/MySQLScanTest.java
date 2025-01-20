package redisclienteval;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class MySQLScanTest {
    public static void main(String[] args) throws Exception{
        Connection connection = null;
        try {
            // 加载MySQL驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 创建连接
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "password";
            connection = DriverManager.getConnection(url, username, password);
            // 执行查询或更新操作
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            if (connection != null) {
                connection.close();
            }
        }
    }
}