package testException;
/**
 * 定义一个方法，根据参数值决定是否抛出异常
 * */
public class AgeInput {
	public static void checkAage(int age)throws AgeOutOfBound{	//用关键字throws指明调用此方法可能抛出的异常
		if(age>0 && age<200){
			System.out.print("right!");
		}else{
			System.out.println("---------------");
			throw new AgeOutOfBound();		//抛出异常用关键字throw
		}
	}
}
