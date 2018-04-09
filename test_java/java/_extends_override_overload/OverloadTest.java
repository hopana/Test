package _extends_override_overload;

public class OverloadTest {
    public static void test(Object s) {
        System.out.println("test1");
    }

    public static void test(String s) {
        System.out.println("test2");
    }

    public static void main(String[] args) {
        Object o = new String("test");

        test(o);
    }

}
