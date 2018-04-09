package thread.wait_notify;

/*
 * 本程序的_Sample类的加减操作中，为何用notify或导致活锁？
 */
public class IncDecTest1 {
    public static void main(String[] args) {
        _Sample sample = new _Sample();

        Thread t1 = new _IncThread(sample);
        Thread t2 = new _DecThread(sample);

        Thread t3 = new _IncThread(sample);
        Thread t4 = new _DecThread(sample);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class _Sample {
    private int number;

    public synchronized void increase() {
        while (0 != number) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(number);
        notify(); // 为什么notify会导致活锁，而notifyAll不会
    }

    public synchronized void decrease() {
        while (0 == number) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(number);
        notify(); // 为什么notify会导致活锁，而notifyAll不会
    }
}

class _IncThread extends Thread {
    private _Sample sample;

    public _IncThread(_Sample sample) {
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            sample.increase();
        }
    }

}

class _DecThread extends Thread {
    private _Sample sample;

    public _DecThread(_Sample sample) {
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            sample.decrease();
        }
    }
}