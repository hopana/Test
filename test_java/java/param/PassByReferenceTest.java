package param;

public class PassByReferenceTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "胡盼";
        p.age = 26;

        Oper o = new Oper();

        o.oper(p);

        System.out.println(p.name + " " + p.age);
    }
}


class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Oper {
    public void oper(Person p) {
        p.name = "newName";
        p.age = 100;
    }
}