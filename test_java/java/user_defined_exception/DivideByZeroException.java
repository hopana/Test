package user_defined_exception;

/**
 * 自定义异常：除零异常
 */
public class DivideByZeroException extends Exception {
    public DivideByZeroException(String msg) {
        super(msg);
    }
}
