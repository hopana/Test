package date;

import java.util.Date;

public class DatePlusTest {
    public static void main(String[] args) {
        Date date = new Date();
        date.setTime(date.getTime() + 10 * 60 * 60 * 24 * 1000);
        System.out.println(date.toLocaleString());
    }
}
