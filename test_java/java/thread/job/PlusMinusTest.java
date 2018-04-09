package thread.job;

/**
 * 加一线程与减一线程共同操作一个数
 * 两个问题：
 * 1、线程同步--synchronized
 * 2、线程之间如何共享同一个变量--内部类
 */
public class PlusMinusTest {
    int j = 1;

    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + ":" + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + ":" + j);
    }

    class IncClass implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class DecClass implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }

    public static void main(String[] args) {
        PlusMinusTest t = new PlusMinusTest();

        IncClass inc = t.new IncClass();
        DecClass dec = t.new DecClass();

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(inc, "加");
            thread.start();

            Thread thread1 = new Thread(dec, "减");
            thread1.start();
        }

    }
}
