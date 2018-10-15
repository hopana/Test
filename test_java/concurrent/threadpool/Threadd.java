package threadpool;


import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-3 上午10:59:18
 */
public class Threadd {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ExecutorService es = Executors.newFixedThreadPool(5);// 初始化五条线程，当使用的时候就使用，没有访问就挂起
        runn r = new runn();

        int i = Integer.parseInt(s.nextLine());// 此处从控制台输入工作的线程数量

        while (--i > 0) {
            es.execute(r);
        }

        while (true) {
            if (es.isTerminated()) {
                System.out.println("线程任务已经都完成");
                break;
            }
        }
        es.shutdown();
        try {
            Thread.sleep(1000);
            if (es.isShutdown()) {
                System.out.println("线程池已经销毁完毕。");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class runn implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在运行");
    }

}