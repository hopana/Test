package string;

import java.util.Date;

public class ToString {
    public static void main(String[] args) {
        Date date = new Date(2012 - 05 - 29);
        String dateStr1 = date + "";
        String dateStr2 = date.toString();
        String str = null;
        System.out.println("dateStr1:  " + dateStr1);
        System.out.println("dateStr2:  " + dateStr2);
        System.out.println("+\"\"和toString()的区别");
        System.out.println(str + "");
        //System.out.println(str.toString()); 空指针异常
    }
}
