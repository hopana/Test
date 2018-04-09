package user_defined_exception;

public class NumberDivideTest {

    public int divide(int x, int y) throws DivideByNegativeNumberException, DivideByZeroException {
        if (y < 0) {
            throw new DivideByNegativeNumberException("您输入的是" + y + ",规定除数不能为负数!");// 抛出异常
        }
        if (y == 0) {
            throw new DivideByZeroException("您输入的是" + y + ",除数不能为0!");
        }

        int m = x / y;
        return m;
    }

    public static void main(String[] args) {
        NumberDivideTest ndt = new NumberDivideTest();
        try {
            ndt.divide(1, -1);
        } catch (DivideByNegativeNumberException e) {
            e.printStackTrace();
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
    }

}
