package thread.producer_consumer.multiple_producer_multiple_consumer;

/**
 * 消费者
 *
 * @author hupan
 * @date 2017-08-17 17:08:20
 */
class Consumer extends Thread {

    // 生产者和消费者操作的是同一个对象，因此必须持有这个对象的引用
    private Storage storage;

    // 构造生产者的时候，将Storage引用传进去
    public Consumer(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        try {
            while (true) {

                if (Storage.NUM == 0) {
                    System.out.println("消费：" + 0 + ",线程终止");
                    break;
                }

                Integer num = storage.get();
                System.out.println("消费：" + num);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}