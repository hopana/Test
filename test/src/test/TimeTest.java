package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String s = sdf.format(new Date(time));
		System.out.println(s);
		System.out.println(s.substring(11));
		System.out.println(s.substring(11).replaceAll(":", "").replaceAll("\\.", ""));
	}
}
