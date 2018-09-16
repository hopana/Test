package thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 *
 * @author hupan
 * @date 2018/09/14
 */
public class CyclicBarrierDemo {
    private static int SIZE = 5;

    private static CyclicBarrier cb;

    public static void main(String[] args) {
        cb = new CyclicBarrier(SIZE);
        for (int i = 0; i < SIZE; i++) {
            new MyTask().start();
        }

    }

    static class MyTask extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("线程" + Thread.currentThread().getName() + "正在执行同一个任务");
                // 以睡眠来模拟几个线程执行一个任务的时间
                Thread.sleep(1000);
                System.out.println("线程" + Thread.currentThread().getName() + "执行任务完成，等待其他线程执行完毕");
                // 用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入完毕");
        }

    }
}
