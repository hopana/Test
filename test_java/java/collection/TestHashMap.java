package collection;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<Object, Object>();

        map.put(null, "value为空");
        map.put("key为空", null);
        map.put(null, null);

        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            System.out.println("key:" + key + " value:" + value);
        }

    }
}
