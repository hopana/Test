package test;

public class ParseUrlParams {
	public static void main(String[] args) {
		String url = "http://y.yeahka.com/wap/swiper2/jp/1.html?comeFrom=2086";
		
		String comefrom = "";
		
		String[] urlarr = url.split("\\?");
		if (urlarr.length > 1) {
			String param = urlarr[1];
			String[] pair = param.split("&");
			
			for (String s : pair) {
				String[] kv = s.split("=");
				if (kv[0].equalsIgnoreCase("comeFrom")) {
					comefrom = kv[1];
				}
			}
		}
		
		System.out.println(comefrom);
	}
}
