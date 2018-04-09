package thread.producer_consumer.demo3;

/**
 * 测试类
 */
public class TestPC {
    public static void main(String[] args) {
        ShareValue value = new ShareValue(0);
        Runnable pr = new Producer(value);
        Runnable cr = new Consumer(value);
        new Thread(pr).start();
        new Thread(cr).start();
    }
}
