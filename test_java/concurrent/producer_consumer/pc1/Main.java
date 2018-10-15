package producer_consumer.pc1;

/**
 * 测试类
 *
 * @author hupan
 * @date 2018/10/15
 */
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        producer.start();
        consumer.start();
    }
}
