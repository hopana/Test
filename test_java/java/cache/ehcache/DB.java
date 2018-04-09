package cache.ehcache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-10 下午3:05:45
 */
public class DB {
    public static final String url = "jdbc:mysql://127.0.0.1/demo";
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String pswd = "admin";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pswd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
