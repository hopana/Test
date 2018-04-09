package user_defined_exception;

/**
 * 自定义异常：除负数异常
 */
public class DivideByNegativeNumberException extends Exception {
    public DivideByNegativeNumberException(String msg) {
        super(msg);
    }
}
