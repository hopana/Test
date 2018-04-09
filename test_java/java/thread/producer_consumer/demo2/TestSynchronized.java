package thread.producer_consumer.demo2;

public class TestSynchronized implements Runnable {
    TimerDemo timer = new TimerDemo();

    public static void main(String[] args) {
        TestSynchronized test = new TestSynchronized();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}

class TimerDemo {
    private static int num = 0;

    public synchronized void add(String name) {
        synchronized (this) {
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ",你是第" + num + "个使用timer的线程");
        }
    }
}