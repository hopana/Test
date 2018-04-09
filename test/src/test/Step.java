package test;

public class Step {
	public static void main(String[] args) {
		System.out.println(getWalkWays(2));
	}
	
	public static int getWalkWays(int n) {
		if (n >= 0 && n <=2) return n;
		
		return getWalkWays(n-1) + getWalkWays(n-2);
	}
	
	public void getWalkTrack(int n) {
		if (n >= 0 && n <= 1) 
			System.out.println(n + " ");
		else {
			
		}
	}
	
}
