package collection;

import java.util.Hashtable;
import java.util.Map;

public class TestHashtable {
    public static void main(String[] args) {
        Map<Object, Object> table = new Hashtable<Object, Object>();

        table.put(null, "value为空"); // 报错
        table.put("key为空", null);   // 报错

        for (Map.Entry<Object, Object> entry : table.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            System.out.println("key:" + key + " value:" + value);
        }

    }
}
