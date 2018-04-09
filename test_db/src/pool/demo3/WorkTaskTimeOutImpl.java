package pool.demo3;

/*
 * 任务类3
 * 执行超时的工作任务
 */
public class WorkTaskTimeOutImpl extends WorkTaskImpl{
	public WorkTaskTimeOutImpl(String param) {
		super(param);
	}
	@Override
	public void execute() throws Exception {
		System.out.println("正在"+param);
	    Thread.sleep(50000); //随便定义
	}
}
