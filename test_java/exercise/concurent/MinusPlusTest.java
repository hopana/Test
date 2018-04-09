package concurent;

public class MinusPlusTest {
    static int num = 0;

    class Minus implements Runnable {
        Object obj;

        public Minus(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                while (num == 1) {
                    num++;
                    System.out.println(num);
                    obj.notifyAll();
                }

                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class Plus implements Runnable {
        Object obj;

        public Plus(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                while (num == 0) {
                    num--;
                    System.out.println(num);
                    obj.notifyAll();
                }

                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Object obj = new Object();

        Plus plus = new MinusPlusTest().new Plus(obj);
        Minus minus = new MinusPlusTest().new Minus(obj);

        new Thread(plus).start();
        new Thread(plus).start();
        new Thread(minus).start();
        new Thread(minus).start();
    }

}
