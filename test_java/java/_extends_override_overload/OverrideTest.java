package _extends_override_overload;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {
    public static void main(String[] args) throws IOException {
        Parent p = new Son();
        System.out.println(p.func(5));
    }
}


class Parent {
    protected int func(int i) throws IOException {
        return 0;
    }
}

class Son extends Parent {
//	访问级别不能更严格
//	private int func(int i) {
//		return 0;
//	}

//  返回值必须一样
//	public String func(int i) {
//		return "0";
//	}

    // 可以抛出与父类不一样的异常
//	public int func(int i) throws NullPointerException{
//		return 1;
//	}

//	不可 抛出比被重写方法更广的异常
//	public int func(int i) throws Exception{
//		return 0;
//	}

    public int func(int i, String j) throws FileNotFoundException {
        return 2;
    }

    public int func(int i, int j) {
        return 3;
    }


    public int func() {
        return 4;
    }
}