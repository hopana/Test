package exception;


/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-3 上午8:15:02
 */
public class GetMessageTest {
    public static void main(String[] args) {
        int i = 0;
        int j = 100;
        int k = 0;
        try {
            k = j / i;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("k=" + k);
    }
}
