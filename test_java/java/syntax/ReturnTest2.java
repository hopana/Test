package syntax;

public class ReturnTest2 {

}

class SuperClassDemo {
    public float getNum() {
        return 3.0f;
    }
}

class SubClassDemo extends SuperClassDemo {
    // A.正确的重写
    public float getNum() {
        return 4.0f;
    }

    // B.非正确的重写，返回值不一样
//	public void getNum() {
//	
//	}

    // C.参数不一样，不是重写方法
//	public void getNum(double d) {
//	}
//
    // D.参数不一样，不是重写方法
//	public double getNum(float d) {
//		return 4.0d;
//	}
}