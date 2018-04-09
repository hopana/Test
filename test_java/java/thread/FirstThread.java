package thread;

public class FirstThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    System.out.println(Thread.currentThread().getName() + ": i=" + i++);
                }
            }

        }).start();

        int i = 100;
        while (i > 0) {
            System.out.println(Thread.currentThread().getName() + ": i=" + i--);
        }
    }
}
