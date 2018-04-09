package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectIsCollectionType {
	public static void isCollectionType(Object o) {
		if (o instanceof List || o instanceof Map || o.getClass().isArray()) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
	
	public static void main(String[] args) {
		String[] a = new String[10];
		List b = new ArrayList();
		Map c = new HashMap();
		
		isCollectionType(a);
		isCollectionType(b);
		isCollectionType(c);
	}
}
