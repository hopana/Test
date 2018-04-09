package thread.wait_notify;

public class TestWaitNotify extends Thread {
    public static void main(String[] args) {
        A a = new A();

        Inc t1 = new Inc(a, "inc");
        Dec t2 = new Dec(a, "dec");

        t1.start();
        t2.start();
    }

}

class A {
    int i = 1;

    public synchronized void inc() {
        i++;

        System.out.println(Thread.currentThread().getName() + "-" + i);

        if (i % 4 == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // wait后，后面的代码是不会执行的
            System.out.println("inc线程等待，通知其他线程");
            notify();
        }
    }

    public synchronized void dec() {
        i--;

        System.out.println(Thread.currentThread().getName() + "-" + i);

        if (i % 5 == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // wait后，后面的代码是不会执行的
            System.out.println("dec线程等待，通知其他线程");
            notify();
        }
    }

}

class Inc extends Thread {

    private A a;

    public Inc(A a, String name) {
        super(name);
        this.a = a;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            a.inc();
        }

    }

}

class Dec extends Thread {

    private A a;

    public Dec(A a, String name) {
        super(name);
        this.a = a;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            a.dec();
        }

    }

}