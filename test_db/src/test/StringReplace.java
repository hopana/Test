package test;

public class StringReplace {
	public static String replace(String con, String tag, String rep) {
		int j = 0;
		int i = 0;
		String RETU = "";
		String temp = con;
		int tagc = tag.length();
		while (i < con.length()) {
			if (con.substring(i).startsWith(tag)) {
				temp = con.substring(j, i) + rep;
				RETU += temp;
				i += tagc;
				j = i;
			} else {
				i += 1;
			}

		}

		RETU += con.substring(j);
		return RETU;
	}

	public static String replace2(String strSource, String strFrom, String strTo) {
		if (strSource == null) {
			return null;
		}
		int i = 0;
		if ((i = strSource.indexOf(strFrom, i)) >= 0) {
			char[] cSrc = strSource.toCharArray();
			char[] cTo = strTo.toCharArray();
			int len = strFrom.length();
			StringBuffer buf = new StringBuffer(cSrc.length);
			buf.append(cSrc, 0, i).append(cTo);
			i += len;
			int j = i;
			while ((i = strSource.indexOf(strFrom, i)) > 0) {
				buf.append(cSrc, j, i - j).append(cTo);
				i += len;
				j = i;
			}
			buf.append(cSrc, j, cSrc.length - j);
			return buf.toString();
		}
		return strSource;
	}

	public static void main(String[] args) {
		String str = " corbape rtorc++c#linux.netjava ";
		System.out.println(replace2(str, "java", "c++"));
	}
}
