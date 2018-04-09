package mathlogic;

public class TernaryExpressionTest {
    public static void main(String[] args) {
        //String s = "CNY";
        String s = "USD";
        String currency = "CNY".equals(s) ? "1" : "0";
        System.out.println(currency);
    }
}
