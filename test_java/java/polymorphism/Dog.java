package polymorphism;

/**
 * 父类
 *
 * @author hupan
 * @date 2018/08/12
 */
public abstract class Dog {
    protected String name;
    protected int age;

    public void bark() {
        System.out.println("dog wang wang ....");
    }
}


class PitBull extends Dog {

    @Override
    public void bark() {
        System.out.println("pitbull wang wang ....");
    }

    public static void main(String[] args) {
        Dog dog = new PitBull();
        dog.bark();
    }
}