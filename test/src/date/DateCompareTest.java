package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCompareTest {
	public static void main(String[] args) throws ParseException {
		Date edate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-08-31 23:59:59");
		Date date = new Date();

		if (date.after(edate)) {
			System.out.println("礼物领取失败：活动已结束！");
		}
	}
}
