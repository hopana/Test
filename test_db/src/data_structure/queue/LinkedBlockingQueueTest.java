package data_structure.queue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue实现生产者消费者模式
 *
 * @author hupan
 * @since 2018-03-26 11:25
 */
public class LinkedBlockingQueueTest {
    private static final LinkedBlockingQueue<Integer> resource = new LinkedBlockingQueue<>(1);

    public static void main(String[] args) {
        new Thread(new Producer2(resource)).start();
        new Thread(new Producer2(resource)).start();
        new Thread(new Comsumer2(resource)).start();
        new Thread(new Comsumer2(resource)).start();
    }

}


class Producer2 implements Runnable {
    private final LinkedBlockingQueue<Integer> queue;

    public Producer2(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Integer randomNumber = new Random().nextInt(100);
            boolean flag = queue.offer(randomNumber);
            if (flag) {
                System.out.println("生产者生产了：" + randomNumber + ", 队列长度：" + queue.size());
            }
        }
    }
}

class Comsumer2 implements Runnable {
    private final LinkedBlockingQueue<Integer> queue;

    public Comsumer2(LinkedBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                Integer i = queue.take();
                System.out.println("消费者消费了：" + i + ", 队列长度：" + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}