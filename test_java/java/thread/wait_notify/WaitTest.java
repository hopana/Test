package thread.wait_notify;

/**
 * 模拟不合理的使用wait导致线程无限等待，假死
 * 
 * @author HP
 */
public class WaitTest {
	Object o = new Object();

	public static void main(String[] args) {
		WaitTest wt = new WaitTest();

		wt.new ThreadDemo1().start();
		wt.new ThreadDemo2().start();
		wt.new ThreadDemo3().start();
	}

	class ThreadDemo1 extends Thread {
		@Override
		public void run() {
			System.out.print("A线程执行...");

			synchronized (o) {
				if (true) {
					System.out.println("操作1...");
					o.notifyAll();
				} 
				
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class ThreadDemo2 extends Thread {
		@Override
		public void run() {
			System.out.print("B线程执行...");
			synchronized (o) {
				if (true) {
					System.out.println("操作2...");
					o.notifyAll();
				} 
				
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class ThreadDemo3 extends Thread {
		@Override
		public void run() {
			System.out.print("C线程执行...");
			synchronized (o) {
				if (true) {
					System.out.println("操作3...");
					o.notifyAll();
				} 
				
				try {
					o.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
