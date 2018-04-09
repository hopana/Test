package customer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constants.DBType;
import utils.DBUtil;

public class Operator2 {

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

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		File file = null;
		
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
			CSVFileUtil csvu = new CSVFileUtil(file);
			
			List<String> list = new ArrayList<String>();
			while ((lineStr = csvu.readLine()) != null) {

				ln++;
				
				if (ln == 1) {
					System.out.println("读取《" + file.getName() + "》跳过第" + ln + "行");
					log("读取《" + file.getName() + "》跳过第" + ln + "行");
					
					continue;
				}
				
				list = CSVFileUtil.fromCSVLinetoArray(lineStr);
				int size = list.size();

				if (size != 33) {
					System.out.println("读取《" + file.getName() + "》跳过第" + ln + "行：参数长度不等于33[length=" + size + "]");
					log("读取《" + file.getName() + "》跳过第" + ln + "行：参数长度不等于33[length=" + size + "]");
					write(lineStr);
					
					continue;
				}
				
				for (int i=0; i<33; i++) {
					ps.setString(i+1, list.get(i).trim());
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
