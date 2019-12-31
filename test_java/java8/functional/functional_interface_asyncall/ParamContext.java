package functional.functional_interface_asyncall;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一个参数包装类，可以包装任何参数
 *
 * @author hupan
 * @date 2018/12/29
 */
public class ParamContext<R> {
    private Map<String, Object> datas = new HashMap<String, Object>();

    public ParamContext(Object... params) {
        if (params == null || params.length == 0) {
            return;
        }
        for (int i = 0; i < params.length; ) {
            datas.put((String) params[i], params[i + 1]);
            i += 2;
        }
    }

    @SuppressWarnings("unchecked")
    public <R> R get(String key) {
        return (R) datas.get(key);
    }
}


