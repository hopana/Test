package thread.wait_notify.demo0;

public class TestIncDec {
    public static void main(String[] args) {
        Sample sample = new Sample();

        IncThread inc1 = new IncThread(sample, "inc1");
        IncThread inc2 = new IncThread(sample, "inc2");

        DecThread dec1 = new DecThread(sample, "dec1");
        DecThread dec2 = new DecThread(sample, "dec2");

        inc1.start();
        inc2.start();
        dec1.start();
        dec2.start();
    }
}
