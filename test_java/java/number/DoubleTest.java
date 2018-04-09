package number;

import java.text.DecimalFormat;

public class DoubleTest {
    public static void main(String[] args) {
        System.out.println(5.00 - 4.90);
        System.out.println(300 - 210);

        System.out.println("------------");

        double d = (double) 1 / 3;
        System.out.println(d);

        System.out.println("------------");

        String percent = new DecimalFormat("#0.00").format((double) 1 / 3 * 100);
        System.out.println(percent);
    }
}
