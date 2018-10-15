package producer_consumer.pc2;

import producer_consumer.pc1.Storage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO 注释
 *
 * @author hupan
 * @date 2018/10/15
 */
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        ReentrantLock lock = new ReentrantLock();
        Condition p = lock.newCondition();
        Condition c = lock.newCondition();

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
