package upload;

public class TestMethod {
	public TestMethod() {
		try {
			DownFileInfoBean bean = new DownFileInfoBean("http://bcscdn.baidu.com/netdisk/BaiduYunGuanjia_5.4.3.exe", "D:\\temp", "baiduyun.exe", 5, true, null);
			DownFileFetch fileFetch = new DownFileFetch(bean);
			fileFetch.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestMethod();
	}
}
