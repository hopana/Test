package syntax;

public class ReturnTest3 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.getNum();
    }
}

class returnTestSub extends ReturnTest3 {

}

class SuperClass {

    public ReturnTest3 getNum() {
        ReturnTest3 r = new ReturnTest3();

        System.out.println("父类getNum方法.....");

        return r;
    }
}

class Sub extends SuperClass {

    // 重写父类方法时，返回值要和父类方法一样或者是父类方法返回值的子类
    public returnTestSub getNum() {
        System.out.println("子类getNum方法.....");

        return null;
    }

}