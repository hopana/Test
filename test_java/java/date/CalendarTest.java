package date;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        int year = date.getYear();
        int month = date.getMonth();
        if (year > 0) {
            calendar.set(1, year);
        }

        if (month > 0) {
            calendar.set(2, month - 1);
        }
        System.out.println(calendar);
    }
}
