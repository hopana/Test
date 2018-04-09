package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import tools.Utils;

public class DateTest {
    public static void main(String[] args) {
        System.out.println(Utils.getCurrentDate());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        try {
            System.out.println(Utils.stringToDate(date, "yyyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
