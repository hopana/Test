package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateCalcTest {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(format.format(calendar.getTime()));
		
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(format.format(calendar.getTime()));
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(format.format(calendar.getTime()));
		
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		System.out.println(format.format(calendar.getTime()));
	}
}
