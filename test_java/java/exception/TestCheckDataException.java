package exception;

// 非检查型异常 non-checked
public class TestCheckDataException extends RuntimeException {
    public static void main(String[] argc) {
        Peoples pps = new Peoples();
        pps.setnum(101);
    }
}

class Peoples {
    private int num = 0;

    public void setnum(int value) {
        if ((value < 0) || (value > 100)) {
            throw new CheckDataException("Out of bound, num = " + value);
        }
    }
}

class CheckDataException extends RuntimeException {
    public CheckDataException(String message) {
        super(message);
    }
}