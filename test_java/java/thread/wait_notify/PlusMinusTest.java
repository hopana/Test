package thread.wait_notify;

public class PlusMinusTest {
    public static void main(String[] args) {
        SyncData data = new SyncData();
        _Inc inc1 = new _Inc(data, "加线程1");
        _Inc inc2 = new _Inc(data, "加线程2");
        _Dec dec1 = new _Dec(data, "减线程1");
        _Dec dec2 = new _Dec(data, "减线程2");

        inc1.start();
        inc2.start();
        dec1.start();
        dec2.start();
    }

}

/*
 *  共享数据，数据本身的加减操作封装在自己的类内部
 */
class SyncData {
    int i = 0;

    public synchronized void inc() {
        while (i != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        i++;
        System.out.println(Thread.currentThread().getName() + "加1:  " + i);
        notifyAll();
    }

    public synchronized void dec() {
        while (i != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        i--;
        System.out.println(Thread.currentThread().getName() + "减1:  " + i);
        notifyAll();
    }
}

/*
 * 加线程：持有数据类的引用，调用数据类的加方法
 */
class _Inc extends Thread {
    SyncData data;

    public _Inc(SyncData data, String name) {
        super(name);
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            data.inc();
        }
    }
}

/*
 * 减线程：持有数据类的引用，调用数据类的减方法
 */
class _Dec extends Thread {
    SyncData data;

    public _Dec(SyncData data, String name) {
        super(name);
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            data.dec();
        }
    }
}
