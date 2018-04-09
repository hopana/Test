package generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericFoo2<T extends List<String>> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public static void main(String[] args) {
        GenericFoo2<ArrayList<String>> foo1 = new GenericFoo2<ArrayList<String>>();
        GenericFoo2<LinkedList<String>> foo2 = new GenericFoo2<LinkedList<String>>();

        foo1.setFoo(new ArrayList<String>());
        foo2.setFoo(new LinkedList<String>());

        List list1 = foo1.getFoo();
        List list2 = foo2.getFoo();

        System.out.println(list1);
        System.out.println(list2);

    }
}
