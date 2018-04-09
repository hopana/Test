package upload2;

public class TestMethod {
	public TestMethod() {
		try {
			DownFileInfoBean bean = new DownFileInfoBean("http://download.2345.com/haozip/haozip_v3.0_hj_multi.exe", "D:\\temp", "haozip.exe", 5, true, null);
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
