package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import constants.DBType;
import utils.DBUtil;

public class TestBatch {

	public static void main(String[] args) {
		String sql = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			sql = "insert into customer(id,name) values(?,?)";

			conn = DBUtil.getConnection(DBType.MYSQL);
			ps = conn.prepareStatement(sql);

			for (int i = 1; i < 1000008; i++) {
				ps.setInt(1, i);
				ps.setString(2, "aa" + i);
				ps.addBatch();
				
				if (i % 1000 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}

			ps.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, ps, rs);
		}
	}

}
