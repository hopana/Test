package thread.producer_consumer.producer_consumer_notify;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 篮子
 *
 * @author hupan
 * @date 2017-08-17 17:44:10
 */
public class Bascket {
    int maxSize = 1;
    ArrayBlockingQueue<Integer> queue;

    public Bascket(int size) {
        this.maxSize = size;
        queue = new ArrayBlockingQueue<Integer>(maxSize);
    }

    public boolean isFull() {
        return queue.size() == maxSize;
    }

    public int size() {
        return queue.size();
    }

    public int put(int n)  {
        try {
            queue.put(n);
            return n;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int take()  {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
