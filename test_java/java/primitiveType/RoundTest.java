package primitiveType;

import java.text.DecimalFormat;

public class RoundTest {
    public static void main(String[] args) {
        double d = 3.1416926;
        DecimalFormat df = new DecimalFormat("##.000");
        d = Double.parseDouble(df.format(d));
        System.out.println(d);
    }
}
