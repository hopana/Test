package thread.producer_consumer.multiple_producer_multiple_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 共享数据
 *
 * @author hupan
 * @date 2017-08-17 17:07:23
 */
class Storage {

    /** 空间大小为1的阻塞队列 */
    private BlockingQueue<Integer> queue = new SynchronousQueue<>();

    public static int NUM = -1;

    public void put(Integer number) {

        try {
            queue.put(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int get() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}