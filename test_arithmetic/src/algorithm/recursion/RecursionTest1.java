package algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * comment
 *
 * @author hupan
 * @since 2018-02-28 16:14
 */
public class RecursionTest1 {

    public static void main(String[] args) {
        Map map = new HashMap(5);
        map.put("a", "shanghai");
        map.put("b", "beijing");
        map.put("c", "shenzhen");
        map.put("d", "nanjing");
        map.put("e", "wuhan");

        System.out.println(getParamValue(map, "f"));
    }

    private static Object getParamValue(Object params, String key) {
        if (params == null || !(params instanceof Map)) {
            return null;
        }

        Map<String, Object> paramMap = (Map<String, Object>) params;

        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            String paramName = entry.getKey();
            Object paramValue = entry.getValue();
            if (paramValue != null && paramValue instanceof Map) {
                // 这里不加return为啥不行
                getParamValue(paramValue, key);
            } else {
                if (paramName.equalsIgnoreCase(key)) {
                    return paramValue;
                }
            }
        }

        return null;
    }
}
