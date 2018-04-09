package pool.demo2;

import java.util.Collection;
import java.util.Vector;

/**
 * 任务分发器
 */
public class TaskManage extends Thread{
	protected Vector<Runnable> tasks = new Vector<Runnable>();
	protected boolean running = false;
	protected boolean stopped = false;
	protected boolean paused = false;
	protected boolean killed = false;
	private ThreadPool pool;

	public TaskManage(ThreadPool pool) {
		this.pool = pool;
	}

	public void putTask(Runnable task) {
		tasks.add(task);
	}

	public void putTasks(Runnable[] tasks) {
		for (int i = 0; i < tasks.length; i++)
			this.tasks.add(tasks[i]);
	}

	public void putTasks(Collection<Runnable> tasks) {
		this.tasks.addAll(tasks);
	}

	protected Runnable popTask() {
		if (tasks.size() > 0)
			return (Runnable) tasks.remove(0);
		else
			return null;
	}

	public boolean isRunning() {
		return running;
	}

	public void stopTasks() {
		stopped = true;
	}

	public void stopTasksSync() {
		stopTasks();
		while (isRunning()) {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pauseTasks() {
		paused = true;
	}

	public void pauseTasksSync() {
		pauseTasks();
		while (isRunning()) {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void kill() {
		if (!running)
			interrupt();
		else
			killed = true;
	}

	public void killSync() {
		kill();
		while (isAlive()) {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void startTasks() {
		running = true;
		this.notify();
	}

	public synchronized void run() {
		try {
			while (true) {
				if (!running || tasks.size() == 0) {
					pool.notifyForIdleThread();
					this.wait();
				} else {
					Runnable task;
					while ((task = popTask()) != null) {
						task.run();
						if (stopped) {
							stopped = false;
							if (tasks.size() > 0) {
								tasks.clear();
								System.out.println(Thread.currentThread().getId() + ": Tasks are stopped");
								break;
							}
						}
						if (paused) {
							paused = false;
							if (tasks.size() > 0) {
								System.out.println(Thread.currentThread().getId() + ": Tasks are paused");
								break;
							}
						}
					}
					running = false;
				}

				if (killed) {
					killed = false;
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
	}
}
