package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 学习用jdbc连接postgre数据库
 */
public class TestPostgreDB {

    private static final String JDBC_POSTGRE_DRIVER = "org.postgresql.Driver";

    private static final String DB_URL = "jdbc:postgresql://10.157.138.246:5432/test";

    private static final String USER = "replicator";

    private static final String PASS = "1q2w3e4r";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(JDBC_POSTGRE_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(" 实例化Statement对象...");
            String sql = "select id,name,sex,idcard,time from websites where id=? limit 2";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "123");
            ResultSet rs = pstmt.executeQuery(); /* 注意一定不要是pstmt.executeQuery(sql) */
            while (rs.next()) {
                rs.getString(1);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pstmt) {
                    pstmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
