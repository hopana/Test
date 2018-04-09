package test;

public class IfElseTest {

    public static void test(String s) {
        if ("".equals(s)) {
            System.out.println("为空");
        } else {
            System.out.println("不为空");
        }
    }

    public static void main(String[] args) {
        String s = "";
        test(s);
        int n = 90;
        if (n >= 100) {
            System.out.println("大于100");
        } else {
            System.out.println("小于100");
        }
    }
}
