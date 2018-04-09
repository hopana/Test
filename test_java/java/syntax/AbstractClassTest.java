package syntax;

public abstract class AbstractClassTest {
    public String name;

    public void sayHello() {
        System.out.println("hello...");
    }

    public abstract void sayGoodbye();

    public AbstractClassTest() {
        System.out.println("constructor...");
    }

}

abstract class son extends AbstractClassTest {

}

abstract class grandson extends son {

}