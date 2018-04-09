package string;

/**
 * @author Administrator
 * @version 2.0
 * @comment：
 * @created 2016-2-23 下午10:04:05
 */
public class StringEqualsTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = s1;
        String s3 = "abc";
        String s4 = new String("abc");
        String s5 = new String("abc");

        System.out.println(s2 == s1); // true
        System.out.println(s3 == s1); // true
        System.out.println(s4 == s3); // false
        System.out.println(s5 == s4); // false;

    }
}
