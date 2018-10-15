package producer_consumer.pc1;

/**
 * 消费者
 *
 * @author hupan
 * @date 2018/10/15
 */
public class Consumer extends Thread {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                consume(Thread.currentThread().getName());
                Thread.sleep(700);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
