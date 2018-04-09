package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewDateTest {
    public static void main(String[] args) {
        int a = 2147483647;//
        Date date = new Date();
        System.out.println(date);
        Date nowTime = Calendar.getInstance().getTime();
        System.out.println(nowTime);
        String time = new SimpleDateFormat("hh:mm:ss", java.util.Locale.US).format(new Date());
        System.out.println(time);
        System.out.println(a);
    }
}
