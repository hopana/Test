package thread.producer_consumer.producer_consumer_notify;

/**
 * 测试类
 *
 * @author hupan
 * @date 2017-08-17 18:11:0
 */
public class Test {
    public static void main(String[] args) {
        Bascket bascket = new Bascket(5);

        Producer producer = new Producer(bascket);
        Consumer consumer = new Consumer(bascket);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
