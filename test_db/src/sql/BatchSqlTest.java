package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import constants.DBType;
import utils.DBUtil;

public class BatchSqlTest {
	public static void main(String[] args) {
		String sql1 = "insert into t_ad_key(`id`, `key`, `url`) values(?,?,?)";
		String sql2 = "update t_ad_key set `key_url` = ? where `key` = ? and `url` = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection(DBType.MYSQL);
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

			for (int i = 1; i < 10; i++) {
				ps.setInt(1, new Random().nextInt(10000) + 1);
				ps.setString(2, i + "");
				ps.setString(3, "aa" + i);
				ps.addBatch();
			}

			ps.executeBatch();
			rs = ps.getGeneratedKeys();

			List<Integer> idList = new ArrayList<Integer>();
			while (rs.next()) {
				idList.add(rs.getInt(1));
			}

			ps = conn.prepareStatement(sql2);

			for (int i=1; i<idList.size(); i++) {
				String keyurl = "http://www.baidu.com?keyid=" + idList.get(i);
				ps.setString(1, keyurl);
				ps.setString(2, i + "");
				ps.setString(3, "aa" + i);
				ps.addBatch();
			}

			ps.executeBatch();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, ps, rs);
		}
	}
}
