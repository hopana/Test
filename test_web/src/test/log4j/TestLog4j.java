package test.log4j;

public class TestLog4j {
	public static void main(String[] args) {
		Logger logger = new Logger("");
		try{
			int i = 1;
			int j = 0;
			int n = i/j;
		}catch (Exception e) {
			logger.error("[Exception]@com.hyt.wy.test.TestLog4j", e);
		}
	}
}
