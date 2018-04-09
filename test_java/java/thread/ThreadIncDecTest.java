package thread;

public class ThreadIncDecTest {
	private int j;

	public static void main(String args[]) {
		ThreadIncDecTest tt = new ThreadIncDecTest();
		Inc inc = tt.new Inc();
		Dec dec = tt.new Dec();

		new Thread(inc).start();
		new Thread(inc).start();
		new Thread(dec).start();
		new Thread(dec).start();
	}

	class Inc implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				j++;
				System.out.println(Thread.currentThread().getName() + "-inc:" + j);
			}
		}
	}

	class Dec implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				j--;
				System.out.println(Thread.currentThread().getName() + "-dec:" + j);
			}
		}
	}
}
