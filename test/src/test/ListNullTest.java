package test;

import java.util.Collections;
import java.util.List;

public class ListNullTest {
	public static void main(String[] args) {
		List list = Collections.emptyList();

		if (list != null && list.size() > 0) {
			System.out.println("size>0");
		}
	}
}
