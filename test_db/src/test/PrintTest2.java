package test;

public class PrintTest2 {
	public static void print(int n) {
		//第一层循环控制打印行数
		for (int i = 1; i <= n; i++) {
			//第二层循环控制*个数
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
				//第三层循环控制.个数
				for(int k=1;k<=i;k++){
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(5);
	}
}
