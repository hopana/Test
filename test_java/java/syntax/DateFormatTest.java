package syntax;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
    public static void main(String[] args) {
        //E表示星期
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHmmss E");
        String str = format.format(new Date());
        String[] arr = str.split(" ");
        String date = arr[0];
        String week = arr[1];

        System.out.println(date + week);
    }

}
