package pool.demo2;

public class TopTask implements Runnable
{

    private ThreadPool pool;

    public TopTask()
    {
        super();
    }

    public TopTask(ThreadPool pool)
    {
        super();
        this.pool = pool;
    }

    @Override
    public void run()
    {
        init();
        start();
    }

    /**
     * 初始化验证权限、参数之类
     */
    public void init()
    {

    }

    /**
     * 开始自动任务
     */
    public void start()
    {
        for (int i = 0; i < 10; i++)
        {
            pool.processTask(new BeginAuto());
        }
    }
}
/**
 * 实现类
 */
class BeginAuto implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getId() + "..................");
    }

}


