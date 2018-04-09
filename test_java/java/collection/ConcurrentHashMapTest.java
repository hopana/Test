package collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<Object, Object> map = new ConcurrentHashMap<Object, Object>();

        map.put("test", 1);
        map.put(null, "null");  //key 不允许为空
        //map.put("null", null); //value 不允许为空
    }
}
