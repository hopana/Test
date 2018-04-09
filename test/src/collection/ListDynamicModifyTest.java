package collection;

import java.util.ArrayList;
import java.util.List;

public class ListDynamicModifyTest {
	public static void main(String[] args) {
		AClass a = new AClass();
		AClass b = new AClass();
		a.setName("a");
		a.setAge(1);
		b.setName("b");
		b.setAge(2);
		
		List<AClass> list = new ArrayList<AClass>();
		list.add(a);
		list.add(b);
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAge(100);
		}
		
		for (AClass ac : list) {
			System.out.println("name=" + ac.name + " age=" + ac.age);
		}
	}
}


class AClass {
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}