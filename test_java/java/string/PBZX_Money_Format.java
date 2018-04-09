package string;

public class PBZX_Money_Format {
    public static void main(String[] args) {
        String num = "+000003000000";
        double d = 0;
        if (num.startsWith("+")) {
            d = Double.valueOf(num.substring(1, num.length()));
        }
        System.out.println(d);
    }
}
