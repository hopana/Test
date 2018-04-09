package thread.join;

public class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被join的线程");
                jt.start();
                jt.join(); // main线程调用jt线程的join方法，则jt线程优先执行，main方法必须等到jt线程执行完才执行
            }
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
