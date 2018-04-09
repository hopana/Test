package thread.wait_notify.demo0;

public class Sample {
    int i = 0;

    public synchronized void inc() {
        try {
            while (i == 1) {
                System.out.println(Thread.currentThread().getName() + "-wait");
                wait();
            }

            i++;

            System.out.println(Thread.currentThread().getName() + "-" + i);

            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void dec() {

        try {
            while (i == 0) {
                System.out.println(Thread.currentThread().getName() + "-wait");
                wait();
            }

            i--;

            System.out.println(Thread.currentThread().getName() + "-" + i);

            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
