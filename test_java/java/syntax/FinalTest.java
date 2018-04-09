package syntax;

public class FinalTest {
    public static void main(String[] args) {
        Demo d = new Demo();
        /*
		 * 不能改变final类型的变量的值
		d.a = 10; 
		*/
    }
}

class Demo {
    public final int a = 0;

    public final void test() {

    }

    public void test(String name, int age) {

    }
}

class DemoSon extends Demo {
	/*
	public void test(){
		System.out.println("子类不可重写父类用final修饰的方法");
	}
	*/
}