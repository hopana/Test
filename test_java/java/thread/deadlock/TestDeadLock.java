package thread.deadlock;

class Guy1 implements Runnable {
    Object goods;
    Object money;

    public Guy1(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (money) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 只有得到了money才能释放goods
            synchronized (goods) {
                System.out.println("你先交钱，我再交货！");
            }
        }
    }

}

class Guy2 implements Runnable {
    Object goods;
    Object money;

    public Guy2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (goods) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 只有得到了goods才能释放money
            synchronized (money) {
                System.out.println("你先交货，我再交钱！");
            }
        }
    }

}

public class TestDeadLock {
    public static void main(String[] args) {
        // 公共资源
        Object goods = new Object();
        Object money = new Object();

        Guy1 g1 = new Guy1(goods, money);
        Guy2 g2 = new Guy2(goods, money);
        Thread t1 = new Thread(g1);
        Thread t2 = new Thread(g2);

        t1.start();
        t2.start();

    }
}