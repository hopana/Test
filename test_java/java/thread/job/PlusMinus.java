package thread.job;

public class PlusMinus {
    private int j;

    public static void main(String args[]) {
        PlusMinus tt = new PlusMinus();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }

    class Inc implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                j++;
                System.out.println(Thread.currentThread().getName() + "-inc:" + j);
            }
        }
    }

    class Dec implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                j--;
                System.out.println(Thread.currentThread().getName() + "-dec:" + j);
            }
        }
    }
}
