package thread.producer_consumer.demo3;

/**
 * 消费者类
 */
public class Consumer implements Runnable {
    private ShareValue value;

    public Consumer(ShareValue value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            try {
                value.minus();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

