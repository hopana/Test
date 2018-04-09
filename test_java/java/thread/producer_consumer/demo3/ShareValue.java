package thread.producer_consumer.demo3;

/**
 * 共享值类
 */
public class ShareValue {
    private int count;

    public ShareValue(int count) {
        this.count = count;
    }

    public synchronized void plus() throws InterruptedException {
        if (count <= 100) {
            ++count;
            System.out.println("Producer:" + count);
            this.notifyAll();
        } else {
            System.out.println("值超过100，停止增加!");
            this.wait();
        }
    }

    public synchronized void minus() throws InterruptedException {
        if (count > 0) {
            --count;
            System.err.println("Consumer:" + count);
            this.notifyAll();
        } else {
            System.out.println("值小或等于0，停止减少!");
            this.wait();
        }
    }
}
