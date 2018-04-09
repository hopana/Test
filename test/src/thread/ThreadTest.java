package thread;

public class ThreadTest implements Runnable{
	public static void main(String[] args) {
		new Thread(new ThreadTest()).start();
	}

	@Override
	public void run() {
		System.out.println("run方法运行了...");
		
		for (int i=0;i<50;i++) {
			System.out.println("for循环打印：" + i);
		}
	}
	
}
