package thread;

import java.util.concurrent.atomic.AtomicLong;

public class AtommicIntegerTest {
    public static AtomicLong al = new AtomicLong();

    public static void main(String[] args) {
        al.set(0);

        for (int i = 0; i < 200; i++) {
            new Thread() {
                public void run() {
                    al.getAndIncrement();
                    System.out.println(al.get());
                }
            }.start();
        }
    }
}
