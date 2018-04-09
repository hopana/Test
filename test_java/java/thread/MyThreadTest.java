package thread;

/**
 * 线程练习
 *
 * @author HP
 * @since 2017-02-23 21:25
 */
public class MyThreadTest {
	String s = "A";
	Object o = new Object();

	public static void main(String[] args) {
		MyThreadTest tt = new MyThreadTest();
		new Thread(tt.new PrintA()).start();
		new Thread(tt.new PrintB()).start();
		
		// 注意不能这么写：
		// new Thread(new MyThreadTest().new PrintA()).start();
		// new Thread(new MyThreadTest().new PrintB()).start();
		// 这么写，每次都去new MyThreadTest()的话，会导致PrintA和PrintB线程操作的不是同一个MyThreadTest对象
		// 如果这两个同步线程操作的不行同一个MyThreadTest对象，那synchronized加锁加的就不是同一个Object对象
		// 这样synchronize就没有意义，这两个线程也达不到同步的目的
	}

	class PrintA implements Runnable {
		@Override
		public void run() {
			synchronized (o) {
				for (int i = 0; i <= 20; i++) {
					if ("A".equals(s)) {
						System.out.println(s);
						
						try {
							o.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						s = "A";
						o.notifyAll();
					}
				}
			}
		}
	}

	class PrintB implements Runnable {
		@Override
		public void run() {
			synchronized (o) {
				for (int j = 0; j <= 20; j++) {
					if ("B".equals(s)) {
						System.out.println(s);
						try {
							o.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						s = "B";
						o.notifyAll();
					}
				}
			}
		}
	}
}
