package number;

import java.text.DecimalFormat;

public class Doubleformat {
    public static void main(String[] args) {
        DecimalFormat df1 = new DecimalFormat("#.00");
        DecimalFormat df2 = new DecimalFormat("#0.00");
        DecimalFormat df3 = new DecimalFormat(".##");

        System.out.println(df1.format(21.286));
        System.out.println(df1.format(0.286));

        System.out.println("-------------------------");

        System.out.println(df2.format(21.286));
        System.out.println(df2.format(0.286));

        System.out.println("-------------------------");

        System.out.println(df3.format(21.286));
        System.out.println(df3.format(0.286));
    }

}
