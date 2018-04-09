package string;

/**
 * @author Administrator
 * @version 2.0
 * @comment：
 * @created 2016-2-23 下午10:33:53
 */
public class StringParamTest {

    public static String change(String s) {
        s = "changed";

        return s;
    }

    public static int change(int a) {
        a = 0;

        return a;
    }

    public static void main(String[] args) {
        String s = "hello world";
        change(s);
        int a = 100;
        change(a);

        System.out.println(s);
        System.out.println(change(a));
    }
}
