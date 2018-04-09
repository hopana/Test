package _abstract;

public interface InterfaceTest {
    public String name = "must and default be final";

    public void test();
}

class InterfaceInstantion {
    InterfaceTest it = new InterfaceTest() {

        @Override
        public void test() {

        }

    };
}