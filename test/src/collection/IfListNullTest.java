package collection;

import java.util.List;

public class IfListNullTest {
	public static void main(String[] args) {
		List<String> list = null;
		
		if (list != null && list.size() > 0) {
			System.out.println("list不为空");
		}
		
		if (list == null || list.size() == 0) {
			System.out.println("list为空");
		}
		
		if (list != null || list.size() > 0) {
			System.out.println("list为空");
		}
		
	}
}
