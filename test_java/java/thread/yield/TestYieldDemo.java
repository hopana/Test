package thread.yield;

public class TestYieldDemo extends Thread {
    public TestYieldDemo() {

    }

    public TestYieldDemo(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + "  " + i);
            if (i == 20) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        TestYieldDemo t1 = new TestYieldDemo("???");
        //t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        TestYieldDemo t2 = new TestYieldDemo("???");
        //t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
    }
}
