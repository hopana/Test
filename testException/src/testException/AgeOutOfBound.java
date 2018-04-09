package testException;
/**
 * 自定义异常类
 * */
public class AgeOutOfBound extends Exception {

    public AgeOutOfBound() {
        System.out.print("Sorry,age out of bound !");
    }
}
