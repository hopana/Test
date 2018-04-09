package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * comment
 *
 * @author hupan
 * @date 2017-05-21 17:56:57
 */
public class GenericExample {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Foo>();
        List<Object> list2 = new ArrayList<>();

        //list1.add();
    }

}

class Foo {

}