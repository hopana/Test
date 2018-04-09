package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import constants.DBType;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	private static String DB_MYSQL_CONFIG = "../db_mysql.properties";
	private static String DB_ORACLE_CONFIG = "../db_oracle.properties";

	public static void init(DBType type) {
		Properties properties = new Properties();
		InputStream is = null;
		
		try {
			if (type == DBType.MYSQL) {
				is = DBUtil.class.getResourceAsStream(DB_MYSQL_CONFIG);
			} else {
				is = DBUtil.class.getResourceAsStream(DB_ORACLE_CONFIG);
			}
			
			properties.load(is);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取与数据库的连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection(DBType type) throws Exception {
		init(type);
		
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 * @param stm
	 * @param rs
	 */
	public static void closeConnection(Connection conn, Statement stm, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (stm != null)
				stm.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			System.out.println(DBUtil.getConnection(DBType.MYSQL).getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}