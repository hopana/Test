package img;

public class Inset {
	public static String insertWhiteSpace(String s) {
		if (s == null || "".equals(s)) {
			return s;
		}

		String str = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() -1) {
				str += s.charAt(i) + " ";
			} else {
				str += s.charAt(i);
			}
		}

		return str;
	}

	public static void main(String[] args) {
		System.out.println(insertWhiteSpace("864215312"));
	}
}
