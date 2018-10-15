package producer_consumer.pc1;

/**
 * 生产者
 *
 * @author hupan
 * @date 2018/10/15
 */
public class Producer extends Thread {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                produce(Thread.currentThread().getName());
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void produce(String producer) {
        storage.produce(producer);
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}