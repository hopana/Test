import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 测试CyclicBarrier
 *
 * @author hupan
 * @date 2018/09/18
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("所有玩家进入第 2 关！"));

        for (int i = 1; i <= 4; i++) {
            new Thread(new Player(i, cyclicBarrier)).start();
        }
    }
}

/**
 * 玩家类
 *
 * @author itmyhome
 */
class Player implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int id;

    public Player(int id, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("玩家" + id + "正在玩第 1 关...");
            cyclicBarrier.await();
            System.out.println("玩家" + id + "进入第 2 关...");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}