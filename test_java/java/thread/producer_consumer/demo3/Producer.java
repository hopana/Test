package thread.producer_consumer.demo3;

/**
 * 生产者类
 */
public class Producer implements Runnable {
    private ShareValue value;

    public Producer(ShareValue value) {
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
                value.plus();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
