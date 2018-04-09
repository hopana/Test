package thread.job;

/**
 * 3个线程交替打印ABC10次
 * 
 * @author HP
 */
public class PrintABCSynchronized {
	private int n = 1;
	Object o = new Object();

	public static void main(String[] args) {
		PrintABCSynchronized t = new PrintABCSynchronized();

		new Thread(t.new PrintA()).start();
		new Thread(t.new PrintB()).start();
		new Thread(t.new PrintC()).start();
	}
	

//  错误写法：	
//	错误原因：while循环执行一次就结束了，但是线程wait()后进入锁池了，
//		        导致线程虽然执行逻辑结束了，但是线程却没有退出，仍然再等待获取锁
//	class PrintA implements Runnable {
//		@Override
//		public void run() {
//			synchronized (o) {
//				while (n % 3 == 1 && n <= 30) {
//					System.out.print("A");
//					n++;
//					o.notifyAll();
//				}
//	
//				try {
//					o.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

	class PrintA implements Runnable {
		@Override
		public void run() {
			synchronized (o) {
				while (n <= 30) {
					if (n % 3 == 1) {
						System.out.print("A");
						n++;
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

	class PrintB implements Runnable {
		@Override
		public void run() {
			synchronized (o) {
				while (n <= 30) {
					if (n % 3 == 2) {
						System.out.print("B");
						n++;
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

	class PrintC implements Runnable {
		@Override
		public void run() {
			synchronized (o) {
				while (n <= 30) {
					if (n % 3 == 0) {
						System.out.println("C");
						n++;
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
