package syntax;

public class PassByValueDemo {
    public static void main(String[] args) {
        int i = 10;
        Foo f = new Foo();
        f.changeAge(i);
        System.out.println(i);

        f.name = "Steve";
        f.changeName(f);
        System.out.println(f.name);

    }
}


class Foo {
    String name;
    int age;

    public void changeName(Foo f) {
        f.name = "newName";
    }

    public void changeAge(int age) {
        age = 100;
    }
}