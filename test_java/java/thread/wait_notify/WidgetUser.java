package thread.wait_notify;

import java.util.*;

class Widget {
}

class WidgetMaker extends Thread {
	List<Widget> finishedWidgets = new ArrayList<Widget>();

	public void run() {
		try {
			while (true) {
				Thread.sleep(5000);// act busy
				Widget w = new Widget();
				// 也就是说需要5秒钟才能新产生一个Widget，这决定了一定要用notify而不是notifyAll
				// 因为上面两行代码不是同步的，如果用notifyAll则所有线程都企图冲出wait状态
				// 第一个线程得到了锁，并取走了Widget（这个过程的时间小于5秒，新的Widget还没有生成）
				// 并且解开了锁，然后第二个线程获得锁(因为用了notifyAll其他线程不再等待notify语句
				// ，而是等待finishedWidgets上的锁，一旦锁放开了，他们就会竞争运行)，运行
				// finishedWidgets.remove(0)，但是由于finishedWidgets现在还是空的， 于是产生异常
				// 这就是为什么下面的那一句不能用notifyAll而是要用notify
				
				// ************************ 自己理解 ************************
				// 相当于一个生产者，多个消费者，生产者和消费者锁同一个list，生产者每次只生产一个产品放进list，
				// 消费者每次从list取走一个产品，由于生产产品比较慢，当生产完成一个产品后，如果通知所有消费者去消费的话，
				// 会导致第一个消费者从list取走了一个产品后，生产者还没来得及补充时，第二个消费者又去list里面取产品
				// 这时候，就不能保证生产和消费平衡了

				synchronized (finishedWidgets) {
					finishedWidgets.add(w);
					finishedWidgets.notify(); // 这里只能是notify而不能是notifyAll
				}
			}
		} catch (InterruptedException e) {
		}
	}

	public Widget waitForWidget() {
		synchronized (finishedWidgets) {
			if (finishedWidgets.size() == 0) {
				try {
					finishedWidgets.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// 取走widget
			return finishedWidgets.remove(0);
		}
	}
}

public class WidgetUser extends Thread {
	private WidgetMaker maker;

	public WidgetUser(String name, WidgetMaker maker) {
		super(name);
		this.maker = maker;
	}

	public void run() {
		Widget w = maker.waitForWidget();
		System.out.println(getName() + " got a widget");
	}

	public static void main(String[] args) {
		WidgetMaker maker = new WidgetMaker();
		maker.start();
		new WidgetUser("Lenny", maker).start();
		new WidgetUser("Moe", maker).start();
		new WidgetUser("Curly", maker).start();

	}

}
