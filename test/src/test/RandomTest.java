package test;

public class RandomTest {
	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			int num = (int) (Math.random() * 1000);
			
			String detail = "";
			if (num == 0) {
				detail = "小米手环二代";
			} else if (num >= 1 && num <= 50) {
				detail = "50M流量";
			} else if (num >= 51 && num <= 415) {
				detail = "合家欢月饼";
			} else if (num >= 416 && num <= 780) {
				detail = "幸福月饼";
			} else {
				detail = "下次再来";
			}
			
			System.out.println(detail);
		}
	}
	
}
