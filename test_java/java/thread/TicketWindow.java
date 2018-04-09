package thread;

public class TicketWindow implements Runnable {

    int max = 0;
    Object lock = new Object();

    @Override
    public void run() {

        synchronized (lock) {
            while (true) {
                if (max > 500)
                    break;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + max++);
            }
        }
    }

    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();
        Thread t1 = new Thread(tw, "t1");
        Thread t2 = new Thread(tw, "t2");
        Thread t3 = new Thread(tw, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}