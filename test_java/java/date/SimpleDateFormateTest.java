package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormateTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("hhmmss");
        String datestr = sdf2.format(new Date());
        System.out.println(datestr);
    }
}
