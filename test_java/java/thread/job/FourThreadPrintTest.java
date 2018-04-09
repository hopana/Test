package thread.job;

/**
 * 4个线程，2个线程加1，两个线程减1，实现0101交替打印10次；
 * 
 * @author HP
 */
public class FourThreadPrintTest {
	private int num = 0;
	Object o = new Object();

	public static void main(String[] args) {
		FourThreadPrintTest ftp = new FourThreadPrintTest();

		new Thread(ftp.new Inc(), "Inc1").start();
		new Thread(ftp.new Inc(), "Inc2").start();
		new Thread(ftp.new Dec(), "Dec1").start();
		new Thread(ftp.new Dec(), "Dec2").start();
	}

	class Inc implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				synchronized (o) {
					if (num == 0) {
						num++;
						System.out.println(num);
						o.notifyAll();
					} else {
						try {
							o.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}

	}

	class Dec implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				synchronized (o) {
					if (num == 1) {
						num--;
						System.out.println(num);
						o.notifyAll();
					} else {
						try {
							o.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}

	}

}