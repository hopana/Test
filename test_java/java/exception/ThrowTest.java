package exception;

public class ThrowTest {

    public static void fun1(String s) {
        if ("abc".equals(s)) {
            throw new NumberFormatException();
        }
    }

    public static void fun2(String s) throws NumberFormatException {
        System.out.println(Double.parseDouble(s));
    }

    public static void main(String[] args) {
        String s = "abc";
        fun1(s);
        fun2(s);
    }
}
