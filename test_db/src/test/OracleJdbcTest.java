package test;

import java.sql.*;


public class OracleJdbcTest {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		String sql = "select * from guest";
		try {
			//1、加载驱动
			//DriverManager.registerDriver(Driver driver) 
			//不推荐：如果采用此种方式，会导致驱动程序加载两次，也就是在内存中会有两个Driver对象。
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2、得到连接
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hupan","hupan");
			//3、创建sql对象（Statement/PreparedStatement/CallStatement）
			statement = connection.createStatement();
			//4、通过statement向数据库发出sql指令
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println("id：" + rs.getInt("id")); 
				System.out.println("姓名:" + rs.getString("username"));
				System.out.println("年龄："+rs.getInt("age"));
				System.out.println("密码:"+rs.getString("password"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;//使用垃圾回收
				}
				if (statement != null) {
					statement.close();
					statement = null;//使用垃圾回收
				}
				if (connection != null) {
					connection.close();
					connection = null;//使用垃圾回收
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
