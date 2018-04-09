package pool.demo3;

/**
 * 任务类2
 * 执行报异常的工作任务 
 */
public class WorkTaskExceptionImpl extends WorkTaskImpl{
	public WorkTaskExceptionImpl(String param) {
		super(param);
	}
	@Override
	public void execute() throws Exception {
		throw new Exception("运行WorkTaskExceptionImpl任务时出错");
	}
}