package pool.demo2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * 线程池
 */
public class ThreadPool
{
    protected int maxPoolSize = 10;
    protected int initPoolSize = 5;
    protected Vector<TaskManage> threads = new Vector<TaskManage>();
    protected boolean initialized = false;
    protected boolean hasIdleThread = false;

    public ThreadPool()
    {
        super();
    }

    public ThreadPool(int maxPoolSize, int initPoolSize)
    {
        this.maxPoolSize = maxPoolSize;
        this.initPoolSize = initPoolSize;
    }

    public void init()
    {
        initialized = true;
        for (int i = 0; i < initPoolSize; i++)
        {
            TaskManage thread = new TaskManage(this);
            thread.start();
            threads.add(thread);
        }
    }

    public void setMaxPoolSize(int maxPoolSize)
    {
        this.maxPoolSize = maxPoolSize;
        if (maxPoolSize < getPoolSize()) setPoolSize(maxPoolSize);
    }

    /**
     * 重设当前线程数 若需杀掉某线程，线程不会立刻杀掉，而会等到线程中的事 
     * 务处理完成 但此方法会立刻从线程池中移除该线程，不会等待事务处理结束
     */
    public void setPoolSize(int size)
    {
        if (!initialized)
        {
            initPoolSize = size;
            return;
        }
        else if (size > getPoolSize())
        {
            for (int i = getPoolSize(); i < size && i < maxPoolSize; i++)
            {
                TaskManage thread = new TaskManage(this);
                thread.start();
                threads.add(thread);
            }
        } 
        else if (size < getPoolSize())
        {
            while (getPoolSize() > size)
            {
                TaskManage th = (TaskManage) threads.remove(0);
                th.kill();
            }
        }
    }

    public int getPoolSize()
    {
        return threads.size();
    }

    protected void notifyForIdleThread()
    {
        hasIdleThread = true;
    }

    protected boolean waitForIdleThread()
    {
        hasIdleThread = false;
        while (!hasIdleThread && getPoolSize() >= maxPoolSize)
        {
            try
            {
                Thread.sleep(5);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public synchronized TaskManage getIdleThread()
    {
        while (true)
        {
            for (Iterator<TaskManage> itr = threads.iterator(); itr.hasNext();)
            {
                TaskManage th = (TaskManage) itr.next();
                if (!th.isRunning()) return th;
            }

            if (getPoolSize() < maxPoolSize)
            {
                TaskManage thread = new TaskManage(this);
                thread.start();
                threads.add(thread);
                return thread;
            }

            if (waitForIdleThread() == false) return null;
        }
    }

    public void processTask(Runnable task)
    {
        TaskManage th = getIdleThread();
        if (th != null)
        {
            th.putTask(task);
            th.startTasks();
        }
    }

    public void processTasksInSingleThread(Runnable[] tasks)
    {
        TaskManage th = getIdleThread();
        if (th != null)
        {
            th.putTasks(tasks);
            th.startTasks();
        }
    }

    public void processTasksInSingleThread(Collection<Runnable> tasks)
    {
        TaskManage th = getIdleThread();
        if (th != null)
        {
            th.putTasks(tasks);
            th.startTasks();
        }
    }

}


