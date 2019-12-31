package functional.functional_interface_asyncall;


import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定义一个监听类，里面有两个map，
 * 一个是所调用方法的map，一个是对应参数的map，
 * map的key值是生成的uuid
 *
 * @author hupan
 * @date 2018/12/29
 */
public class ListenCall {
    ConcurrentHashMap<String, GofFunction<ParamContext, ParamContext>> methodMap = new ConcurrentHashMap<String, GofFunction<ParamContext, ParamContext>>();
    ConcurrentHashMap<String, ParamContext> paramMap = new ConcurrentHashMap<String, ParamContext>();

    /**
     * 获取请求编号
     *
     * @return
     */
    public String getCallId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 监听返回值
     *
     * @param method
     * @param callId
     * @param context
     */
    public void listenResult(GofFunction<ParamContext, ParamContext> method, String callId, ParamContext context) {
        methodMap.put(callId, method);
        paramMap.put(callId, context);
    }

    /**
     * 等待处理结果
     *
     * @param result
     * @param callId
     */
    public void waitForResult(ParamContext result, String callId) {
        GofFunction<ParamContext, ParamContext> funtion = methodMap.get(callId);
        if (funtion != null) {
            ParamContext context = paramMap.get(callId);
            if (context == null) {
                context = new ParamContext();
            }

            funtion.execute(result, context);
        }

    }

}

