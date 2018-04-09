package exception;

import java.io.IOException;

/**
 * 当有多个catch语句块的时候，如果前面的catch块里捕获的异常比后面catch块里捕获的异常范围大
 * 则后面的catch 语句块里的代码不会被执行，因为异常是从上往下匹配，已经匹配到就不再往下执行
 * 所以一定要把范围最大的异常放在最后面的catch里
 */
public class ExceptionTryCatchTest {
    public void doSomething() throws IOException {
        System.out.println("do somthing");
    }

    public static void main(String[] args) {
        ExceptionTryCatchTest et = new ExceptionTryCatchTest();
        try {
            et.doSomething();
        } catch (Exception e) {
            // do something
        } //catch (IOException e) {
        // do something
        //}
    }
}
