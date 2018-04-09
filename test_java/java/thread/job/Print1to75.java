package thread.job;

/**
 * 要求创建三个线程，输出1-75，
 * 最开始第一个线程输出1-5，第二个输出6-10，第三个输出11-15
 * 接着再第一个线程输出16-20...就这样循环下去，直到打印出75个数
 *
 * @author qiaoxueshi
 */
public class Print1to75 {

	/**
	 * 内部类
	 */
	static class Printer implements Runnable {

		static int num = 1; // 开始数字
		static final int END = 75;
		int id;

		Object o; // 这就是三个线程的“公证人”，有点寒酸吧

		public Printer(int id, Object o) {
			this.id = id;
			this.o = o;
		}

		@Override
		public void run() {
			synchronized (o) {
				while (num <= END) {
					if (num / 5 % 3 == id) { // 如果是属于自己的数，依次打印出来五个
						System.out.print(id + ":");
						for (int i = 0; i < 5; i++) {
							System.out.print(num++ + ", ");
						}
						System.out.println();

						o.notifyAll();// 放弃CPU使用权，唤醒在o对象的等待队列上的线程
					} else {
						try {
							o.wait(); // 如果不属于自己的数，把当前线程挂在o这个对象的等待队列上（也放弃了CPU使用权），等待唤醒
						} catch (InterruptedException e) {
							System.out.println("线程" + id + "被打断了");
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// 下面可以不按0，1，2的顺序来,而且在两两中间随便sleep()，都会正确打印出来
		Object o = new Object();
		new Thread(new Printer(0, o), "T0").start();
		new Thread(new Printer(1, o), "T1").start();
		new Thread(new Printer(2, o), "T2").start();
	}
}
