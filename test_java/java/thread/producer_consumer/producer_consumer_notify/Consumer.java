package thread.producer_consumer.producer_consumer_notify;

/**
 * 生产者
 *
 * @author hupan
 * @date 2017-08-17 17:45:1
 */
public class Consumer implements Runnable {
    Bascket bascket = null;

    public Consumer(Bascket bascket) {
        this.bascket = bascket;
    }

    @Override
    public void run() {
        synchronized (bascket) {
            while (true) {
                if (bascket.size() == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int n = bascket.take();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费：" + n);

                bascket.notifyAll();
            }
        }
    }
}
