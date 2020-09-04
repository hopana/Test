package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hupan
 * @date 2020/08/13
 */
public class ArrayListSizeTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(16);
        list.add(1);
        list.add(2);

        System.out.println(list.size());
    }

}
