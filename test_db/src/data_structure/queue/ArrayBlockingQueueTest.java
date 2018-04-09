package data_structure.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue实现生产者消费者模式
 *
 * @author hupan
 * @since 2018-03-26 11:25
 */
public class ArrayBlockingQueueTest {
    private static final ArrayBlockingQueue<Integer> resource = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        new Thread(new Producer(resource)).start();
        new Thread(new Producer(resource)).start();
        new Thread(new Comsumer(resource)).start();
        new Thread(new Comsumer(resource)).start();
    }

}


class Producer implements Runnable {
    private final ArrayBlockingQueue<Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue) {
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

class Comsumer implements Runnable {
    private final ArrayBlockingQueue<Integer> queue;

    public Comsumer(ArrayBlockingQueue<Integer> queue) {
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