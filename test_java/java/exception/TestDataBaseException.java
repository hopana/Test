package exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 检查型异常 checked Exception
public class TestDataBaseException extends Exception {
    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        String sql = "select empAddr from emp";

        ResultSet rs = null;

        try {
            rs = cm.execSelectSQL(sql);
            System.out.println("执行成功！");
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }
}

class ConnectionManager {
    public ResultSet execSelectSQL(String sql) throws DataBaseException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new DataBaseException(sql, e);
        }

        return rs;
    }
}

class DataBaseException extends Exception {
    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}