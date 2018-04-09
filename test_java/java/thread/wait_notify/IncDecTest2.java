package thread.wait_notify;

/*
 * 解决IncDecTest1的办法要么是：
 * 1、把Sample类的加减操作中的notify换成notifyAll
 * 2、在加减线程启动时，随机睡眠一段时间，使各个线程的运行几率基本相等
 * 活锁的原因是：程序中线程反复执行同一操作
 */
public class IncDecTest2 {
    public static void main(String[] args) {
        Sample sample = new Sample();

        Thread t1 = new IncThread(sample);
        Thread t2 = new DecThread(sample);

        Thread t3 = new IncThread(sample);
        Thread t4 = new DecThread(sample);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Sample {
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
        notify();
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
        notify();
    }
}

class IncThread extends Thread {
    private Sample sample;

    public IncThread(Sample sample) {
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sample.increase();
        }
    }
}

class DecThread extends Thread {
    private Sample sample;

    public DecThread(Sample sample) {
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sample.decrease();
        }
    }
}