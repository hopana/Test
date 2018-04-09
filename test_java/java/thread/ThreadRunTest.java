package thread;

public class ThreadRunTest {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("子线程打印。。。。。。。");
            }

        }.start();


        System.out.println("主线程打印.......");
    }
}
