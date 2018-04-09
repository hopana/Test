package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
        Date date = new Date();
        String d = sdf.format(date);
        System.out.println(d);
    }
}
