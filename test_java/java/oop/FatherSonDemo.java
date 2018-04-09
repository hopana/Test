package oop;

class Father {
    int a = 6;
    static int b = 8;

    Father() {
        System.out.println("father init...");
    }

    public void fun(String arg) {
        System.out.println("father function..." + arg);
    }
}

class Son extends Father {
    int a = 3;
    static int b = 4;

    Son() {
        System.out.println("son init...");
    }

    public void fun(String arg) {
        System.out.println("son function..." + arg);
    }

}

public class FatherSonDemo {
    public static void main(String[] args) {
        Father f = new Son();

        System.out.println("f.a=" + f.a + " f.b=" + f.b);
        f.fun("aaa");

    }
}