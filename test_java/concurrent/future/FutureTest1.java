package future;

import java.util.concurrent.ExecutionException;

/**
 * Future对照测试，Future具体用法参见FutureTest2
 *
 * @author hupan
 * @date 2020/05/09
 */
public class FutureTest1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTest1 ft = new FutureTest1();
        ft.futureTest();
    }

    public void futureTest() throws InterruptedException {
        long start = System.currentTimeMillis();

        // 等凉菜 -- 必须要等待返回的结果，所以要调用join方法
        Thread t1 = new ColdDishThread();
        t1.start();
        t1.join();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Thread t2 = new BumThread();
        t2.start();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }

    class BumThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000*3);
                System.out.println("包子准备完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    class ColdDishThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("凉菜准备完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
