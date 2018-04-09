package oop;

public class ClassCastDemo {
    public static void main(String[] args) {
        Person p = new Person();
        Teacher t = new Teacher();
        Student s = new Student();

        if (t instanceof Person) {
            // s=(Student) t;  编译不通过

            t = (Teacher) p;   //运行时异常
            t.sing();

            p = (Person) t;    //OK
            t.sing();
        }

    }

}

class Person {
    String name;
    String gender;
    int age;

    public void sing() {
        System.out.println("person sing......");
    }
}

class Teacher extends Person {

}

class Student extends Person {

}