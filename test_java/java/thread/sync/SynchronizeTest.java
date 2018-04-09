package thread.sync;

/**
 * Java线程：线程的同步
 */
public class SynchronizeTest {
    public static void main(String[] args) {
        User u = new User("张三", 100);
        OThread t1 = new OThread("线程A", u, 20);
        OThread t2 = new OThread("线程B", u, -60);
        OThread t3 = new OThread("线程C", u, -80);
        OThread t4 = new OThread("线程D", u, -30);
        OThread t5 = new OThread("线程E", u, 32);
        OThread t6 = new OThread("线程F", u, 21);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}

class OThread extends Thread {
    private User u;
    private int y = 0;

    OThread(String name, User u, int y) {
        super(name);
        this.u = u;
        this.y = y;
    }

    public void run() {
        u.oper(y);
    }
}

class User {
    private String code;
    private int cash;

    User(String code, int cash) {
        this.code = code;
        this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 业务方法
     *
     * @param x 添加x万元
     */
    public synchronized void oper(int x) {
        try {
            Thread.sleep(10L);
            this.cash += x;
            System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户账户余额为：" + cash);
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "User{" + "code='" + code + '\'' + ", cash=" + cash + '}';
    }
}