package thread.job;

/**
 * 金山面试题:
 * 四个线程a,b,c,d. 线程a,b对变量i加一. 线程c,d对变量i减去一.
 * 四个线程顺序执行, 每个线程每次只执行一次.i的初始值为0，
 * 打印结果0 1 2 1 0 1 2 1 0 1
 */
public class Test4Thread {
    static int count = 0;
    static int i = 0;

    static Object o = new Object();

    static class Print implements Runnable {
        int id;

        public Print(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            synchronized (o) {
                for (int j = 0; j < 100; j++) {
                    if (count % 4 != id) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (id == 0 || id == 1) {
                            System.out.println(Thread.currentThread().getName() + "，i=" + i++);
                        }
                        if (id == 2 || id == 3) {
                            System.out.println(Thread.currentThread().getName() + "，i=" + i--);
                        }

                        count++; // 为什么此行放在括号外不行
                    }

                    // count++;

                    o.notifyAll();

                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Print(0), "a").start();
        new Thread(new Print(1), "b").start();
        new Thread(new Print(2), "c").start();
        new Thread(new Print(3), "d").start();
    }
}
