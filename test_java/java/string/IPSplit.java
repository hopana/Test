package string;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-6 下午2:07:46
 */
public class IPSplit {

    public static void main(String[] args) {
        String ip = "192.168.5.41";
        String[] strs = ip.split("\\.");

        for (String n : strs) {
            System.out.println(n);
        }
    }

}
