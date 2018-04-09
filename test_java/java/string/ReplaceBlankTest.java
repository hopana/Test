package string;

/**
 * @author Administrator
 * @version 1.0
 * @comment：替换多个空格至一个
 * @created 2016-02-28 17:01:03
 */
public class ReplaceBlankTest {
    public static void main(String[] args) {
        String s = "S  tr  ing";

        System.out.println(s.replaceAll(" +", " "));
    }
}
