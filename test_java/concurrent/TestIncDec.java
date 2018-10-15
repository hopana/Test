import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestIncDec {
    public static void main(String[] args) {
        Number number = new Number();
        IncThread inc1 = new IncThread("inc1", number);
        IncThread inc2 = new IncThread("inc2", number);
        DecThread dec1 = new DecThread("dec1", number);
        DecThread dec2 = new DecThread("dec2", number);

        inc1.start();
        inc2.start();
        dec1.start();
        dec2.start();
    }
}

class Number {
    int i = 0;

    Lock lock = new ReentrantLock();
    Condition con = lock.newCondition();

    public void inc() {
        try {
            lock.lock();
            while (i != 0) {
                con.await();
            }

            i++;
            System.out.println(Thread.currentThread().getName() + ":" + i);
            con.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void dec() {
        try {
            lock.lock();
            while (i != 1) {
                con.await();
            }

            i--;
            System.out.println(Thread.currentThread().getName() + ":" + i);
            con.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class IncThread extends Thread {
    Number number;

    public IncThread(String name, Number number) {
        super(name);
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            number.inc();
        }
    }

}

class DecThread extends Thread {
    Number number;

    public DecThread(String name, Number number) {
        super(name);
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            number.dec();
        }
    }

}