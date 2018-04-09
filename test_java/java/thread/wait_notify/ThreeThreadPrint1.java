package thread.wait_notify;

public class ThreeThreadPrint1 {
    public static void main(String[] args) {
        Data data = new Data();
        Thread1 t1 = new Thread1(data, "线程1");
        Thread2 t2 = new Thread2(data, "线程2");
        Thread3 t3 = new Thread3(data, "线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Data {

    int number = 1;
    int flag = 1;

    public synchronized void incAndPrint() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + number);
            number++;
        }

        flag = (flag + 1) == 4 ? 1 : (flag + 1);
        notifyAll();

        try {
            wait();
            System.out.println(Thread.currentThread().getName() + ":wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Thread1 extends Thread {
    Data data;

    public Thread1(Data number, String name) {
        super(name);
        this.data = number;
    }

    @Override
    public void run() {
        while (data.number < 75) {
            if (data.flag == 1) {
                data.incAndPrint();
            }
        }
    }

}

class Thread2 extends Thread {
    Data data;

    public Thread2(Data number, String name) {
        super(name);
        this.data = number;
    }

    @Override
    public void run() {
        while (data.number < 75) {
            if (data.flag == 2) {
                data.incAndPrint();
            }
        }
    }

}

class Thread3 extends Thread {
    Data data;

    public Thread3(Data number, String name) {
        super(name);
        this.data = number;
    }

    @Override
    public void run() {
        while (data.number < 75) {
            if (data.flag == 3) {
                data.incAndPrint();
            }
        }
    }

}