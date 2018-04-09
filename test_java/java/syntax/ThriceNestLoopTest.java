package syntax;

/**
 * 三层for循环理解
 *
 * @author hupan
 * @date 2017-08-27 10:53:26
 */
public class ThriceNestLoopTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            System.out.println("--------------------------------------------------");

            for (int j = i; j < 10; j++) {
                System.out.print("j=" + j + ":  ");
                for (int k = i; k <= j; k++) {
                    System.out.print("k=" + k + " ");
                }

                System.out.println();
            }

            System.out.println();
        }
    }
}
