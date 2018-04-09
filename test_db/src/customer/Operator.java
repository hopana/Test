package customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import constants.DBType;
import utils.DBUtil;

public class Operator {

	public static void log(String msg) {
		PrintWriter pw = null;
		
		try {
			File logFile = new File("D:\\customer.log");
			pw = new PrintWriter(new FileWriter(logFile, true), true);
			Date date = new Date();
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			pw.println("[" + now + "] - " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
	
	public static void write(String invalidLine) {

		PrintWriter pw = null;
		
		try {
			File logFile = new File("D:\\customer_invalidLines.txt");
			pw = new PrintWriter(new FileWriter(logFile, true), true);
			pw.println(invalidLine);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	
	}

	public static void main(String[] args) {
		File file = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		String sql = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int ln = 0;
		String lineStr = null;

		try {
			sql = "insert into customer(name,card_no,descriot,ctf_tp,ctf_id,gender,birthday,address,zip,dirty,district1,district2,district3,district4,district5,district6,first_name,last_name,duty,mobile,tel,fax,email,nation,taste,education,company,ctel,caddress,czip,family,version,id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			conn = DBUtil.getConnection(DBType.MYSQL);
			ps = conn.prepareStatement(sql);

			file = new File("D:\\2000W\\1-200W.csv");
			isr = new InputStreamReader(new FileInputStream(file));
			br = new BufferedReader(isr);

			String[] values = null;

			while ((lineStr = br.readLine()) != null) {
				ln++;
				
				if (ln == 1) {
					System.out.println("读取《" + file.getName() + "》跳过第" + ln + "行");
					log("读取《" + file.getName() + "》跳过第" + ln + "行");
					
					continue;
				}
				
				values = lineStr.split(",");

				if (values.length == 33) {
					ps.setString(1, values[0].trim());
					ps.setString(2, values[1].trim());
					ps.setString(3, values[2].trim());
					ps.setString(4, values[3].trim());
					ps.setString(5, values[4].trim());
					ps.setString(6, values[5].trim());
					ps.setString(7, values[6].trim());
					ps.setString(8, values[7].trim());
					ps.setString(9, values[8].trim());
					ps.setString(10, values[9].trim());
					ps.setString(11, values[10].trim());
					ps.setString(12, values[11].trim());
					ps.setString(13, values[12].trim());
					ps.setString(14, values[13].trim());
					ps.setString(15, values[14].trim());
					ps.setString(16, values[15].trim());
					ps.setString(17, values[16].trim());
					ps.setString(18, values[17].trim());
					ps.setString(19, values[18].trim());
					ps.setString(20, values[19].trim());
					ps.setString(21, values[20].trim());
					ps.setString(22, values[21].trim());
					ps.setString(23, values[22].trim());
					ps.setString(24, values[23].trim());
					ps.setString(25, values[24].trim());
					ps.setString(26, values[25].trim());
					ps.setString(27, values[26].trim());
					ps.setString(28, values[27].trim());
					ps.setString(29, values[28].trim());
					ps.setString(30, values[29].trim());
					ps.setString(31, values[30].trim());
					ps.setString(32, values[31].trim());
					ps.setString(33, values[32].trim());
				} else {
					System.out.println("读取《" + file.getName() + "》跳过第" + ln + "行：参数长度不等于33[length=" + values.length + "]");
					log("读取《" + file.getName() + "》跳过第" + ln + "行：参数长度不等于33[length=" + values.length + "]");
					write(lineStr);
					
					continue;
				}

				ps.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println("读取《" + file.getName() + "》第" + ln + "行出错：" + lineStr);
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, ps, rs);
		}
	}

}
