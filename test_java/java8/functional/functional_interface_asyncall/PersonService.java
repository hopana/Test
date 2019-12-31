package functional.functional_interface_asyncall;

/**
 * 定义person的service类，里面有一些逻辑方法，
 * 有一个模拟读取数据库的方法，此方法是多线程的，
 * 模拟读取数据库，线程休眠4秒
 *
 * @author hupan
 * @date 2018/12/29
 */
public class PersonService {

    private ListenCall listenCall = new ListenCall();

    /**
     * 这里模拟根据用户名从数据库查询密码
     *
     * @param name   用户名
     * @param callId 请求调用的id
     */
    public void getPwdFromDb(String name, String callId) {
        new Thread(() -> {
            String sql = "select from person where name=" + "'" + name + "'";
            String pwd = "1111";
                //这里等待4秒，模拟读取数据库的操作，时间有点夸张
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitForResult(new ParamContext("pwd", pwd), callId);
        }).start();
    }

    public String getCallId() {
        return listenCall.getCallId();
    }

    public void waitForResult(ParamContext p, String callId) {
        listenCall.waitForResult(p, callId);
    }

    public void listenResult(GofFunction<ParamContext, ParamContext> method, String callId, ParamContext context) {
        listenCall.listenResult(method, callId, context);
    }
}

