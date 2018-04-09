package collection;

import java.util.Collections;
import java.util.Map;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-7-27 下午2:53:43
 */
public class TestEmptyMap {
    public static void main(String[] args) {
        Map<String, String> map = Collections.EMPTY_MAP;
        String name = map.get("name");
        String age = map.get("age");

        System.out.println(name);
        System.out.println(age);
    }
}   
