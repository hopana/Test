package producer_consumer.pc3;

import producer_consumer.pc1.Storage;

/**
 * 生产者
 *
 * @author hupan
 * @date 2018/10/15
 */
public class Producer extends Thread {
    private String producer;
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        produce(producer);
    }

    public void produce(String producer) {
        storage.produce(producer);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}