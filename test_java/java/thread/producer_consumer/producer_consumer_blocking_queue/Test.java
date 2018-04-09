package thread.producer_consumer.producer_consumer_blocking_queue;

/**
 * 编写一段生产者/消费者的Java代码，其中生产者每次生产1个0到1000之间的随机数，消费者则把该随机数打印出来。
 * 如果产生的随机数为0，则生产者、消费者均退出运行。要求生产者、消费者均使用线程来实现。
 */
public class Test {

    public static void main(String[] args) {
        Storage storage = new Storage();

        new Producer(storage).start();
        new Consumer(storage).start();

    }

}

