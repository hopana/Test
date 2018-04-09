package thread.producer_consumer.multiple_producer_multiple_consumer;

import java.util.Random;

/**
 * 消费者
 *
 * @author hupan
 * @date 2017-08-17 17:08:57
 */
class Producer extends Thread {

    Random random = new Random();

    // 生产者和消费者操作的是同一个对象，因此必须持有这个对象的引用
    private Storage storage;

    // 构造生产者的时候，将Storage引用传进去
    public Producer(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        try {
            while (true) {
                Integer num = random.nextInt(1000);
                Storage.NUM = num;
                if (Storage.NUM == 0) {
                    System.out.println("生产：" + 0 + ",线程终止");
                    break;
                }

                storage.put(num);
                System.out.println("生产：" + num);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}