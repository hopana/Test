package pool.demo3;

/*
 * 任务开始运行事件
 */
public class BeginTaskEvent extends AbstractEvent{
	public BeginTaskEvent(WorkThread workthread,Thread nowthread,WorkTask task){
		this.workthread=workthread;
		this.nowthread=nowthread;
		this.nowtask=task;
	}
	@Override
	public  void execute() {
		// TODO Auto-generated method stub
		ThreadPool pool=ThreadPool.getInstance();
		pool.beginTaskRun(this);
	}
}
