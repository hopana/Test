package thread.join;

/**
 * @author Administrator
 */
public class JoinTest1 implements Runnable {

    public static int a = 0;

    public void run() {
        for (int k = 0; k < 5; k++) {
            a = a + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable r = new JoinTest1();
        Thread t = new Thread(r);
        t.start();
        //t.join();
        System.out.println(a);
    }
}
