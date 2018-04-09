package thread.wait_notify.demo0;

public class IncThread extends Thread {
    private Sample sample;

    public IncThread(Sample sample, String name) {
        super(name);
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            sample.inc();
//			try {
//				Thread.sleep((int)(Math.random() * 1000));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
        }
    }

}
