package testException;
/**
 * 测试类，如果有异常场则捕获
 * */
public class Demo {

	public static void main(String[] args) {
		int age = 300;
	    try {
			AgeInput.checkAage(age);
		} catch (AgeOutOfBound e) {
			 System.out.println("Are you rellly :" + age + " years old?");
		}
	}

}
