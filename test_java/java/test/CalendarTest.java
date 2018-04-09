package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarTest {
    public static void main(String[] args) {
        Date nowDate = new Date();
        Calendar ca = Calendar.getInstance();
        Date time = ca.getTime();
        int first = ca.getFirstDayOfWeek();
        System.out.println(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        System.out.println(format.format(time));
        System.out.println(nowDate);
        System.out.println(format.format(nowDate));
    }
}
