package string;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-6-26 下午2:35:36
 */
public class StringEqualsBoolean {

    public static void main(String[] args) {
        String s = "true";

        if (null != s && "true".equalsIgnoreCase(s)) {
            System.out.println("OK");
        }
    }
}
