package thread.producer_consumer.producer_consumer_notify;

import java.util.Random;

/**
 * 消费者
 *
 * @author hupan
 * @date 2017-08-17 17:45:9
 */
public class Producer implements Runnable {
    Bascket bascket = null;

    public Producer(Bascket bascket) {
        this.bascket = bascket;
    }

    @Override
    public void run() {
        Random random = new Random();
        synchronized (bascket) {
            while (true) {

                if (bascket.isFull()) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int n = bascket.put(random.nextInt(100));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产：" + n);
                bascket.notifyAll();
            }
        }
    }
}
