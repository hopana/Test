package thread.wait_notify.demo0;

public class DecThread extends Thread {
    private Sample sample;

    public DecThread(Sample sample, String name) {
        super(name);
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            sample.dec();
//			try {
//				Thread.sleep((int)(Math.random() * 1000));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
        }
    }

}