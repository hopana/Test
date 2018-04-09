package string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2Data {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("原始格式：  " + new Date());
        System.out.println("格式化后的格式：  " + df.format(new Date()));
        try {
            Date myDate = df.parse(df.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
