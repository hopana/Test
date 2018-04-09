package string;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-6-25 上午10:54:29
 */
public class SplitTest9 {
    public static void main(String[] args) {
        String s = "彭雨,,,ID,34080319811125042X,M,19811125,-,-,,,CHN,-1,-1,,,,,,13033163458,-,-,pengrain1125@tom.com,,,,,,,,,,342";

        String[] arr = s.split(",");

        System.out.println(arr.length);

        for (String a : arr) {
            System.out.print("[" + a + "] ");
        }
    }
}
