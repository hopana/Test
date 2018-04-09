package exception;

public class TestMyException {
    public static void test(int n) throws MyException {
        if (n < 0 || n > 100) {
            throw new MyException("超出范围！");
        } else {
            System.out.println("你输入的数字是：" + n);
        }
    }

    public static void main(String[] args) {
        TestMyException te = new TestMyException();
        try {
            te.test(101);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

class MyException extends Exception {

    String errorMessage;

    public MyException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
