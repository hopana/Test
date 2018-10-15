package producer_consumer.pc1;

import java.util.LinkedList;
import java.util.Random;

/**
 * 共享数据
 *
 * @author hupan
 * @date 2018/10/15
 */
public class Storage {
    private Random random = new Random();
    /**
     * 仓库最大存储量
     */
    private final int MAX_SIZE = 100;

    /**
     * 仓库存储的载体
     */
    private LinkedList<Integer> list = new LinkedList<>();

    // 生产产品
    public void produce(String producer) {
        synchronized (list) {
            // 如果仓库已满
            while (list.size() == MAX_SIZE) {
                System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
                try {
                    // 由于条件不满足，生产阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 生产产品
            int data = random.nextInt(100);
            list.add(data);

            System.out.println("【" + producer + "】：生产了" + data + "【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    // 消费产品
    public void consume(String consumer) {
        synchronized (list) {
            //如果仓库存储量不足
            while (list.size() == 0) {
                System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
                try {
                    // 由于条件不满足，消费阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int data = list.remove();
            System.out.println("【" + consumer + "】：消费了"+ data +"【现仓储量为】:" + list.size());
            list.notifyAll();
        }
    }

    public LinkedList<Integer> getList() {
        return list;
    }

    public void setList(LinkedList<Integer> list) {
        this.list = list;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}