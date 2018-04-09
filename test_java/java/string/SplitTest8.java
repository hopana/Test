package string;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-6-25 上午10:54:29
 */
public class SplitTest8 {
    public static void main(String[] args) {
        String s1 = "2,3,4,";
        String s2 = "2";

        for (String a : s1.split(",")) {
            System.out.print("[" + a + "] ");
        }

        System.out.println();

        for (String b : s2.split(",")) {
            System.out.print("[" + b + "] ");
        }
    }
}
