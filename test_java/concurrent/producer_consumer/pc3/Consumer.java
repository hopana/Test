package producer_consumer.pc3;

import producer_consumer.pc1.Storage;

/**
 * 消费者
 *
 * @author hupan
 * @date 2018/10/15
 */
public class Consumer extends Thread {
    private String consumer;
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        consume(consumer);
    }

    public void consume(String consumer) {
        storage.consume(consumer);
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}
