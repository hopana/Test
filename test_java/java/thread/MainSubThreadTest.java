package thread;

public class MainSubThreadTest {

    public static void main(String[] args) {
        new MainSubThreadTest().init();

    }

    public void init() {
        final Business business = new Business();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.SubThread(i);
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            business.MainThread(i);
        }
    }

    private class Business {
        boolean flag = true;// 这里相当于定义了控制该谁执行的一个信号灯

        public synchronized void MainThread(int i) {
            if (flag)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            for (int j = 0; j < 5; j++) {
                System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
            }
            flag = true;
            notify();

        }

        public synchronized void SubThread(int i) {
            if (!flag)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + ":i=" + i + ",j=" + j);
            }
            flag = false;
            this.notify();
        }
    }

}
