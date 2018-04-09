package test;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
	public static void main(String[] args) {
		List<D> list = new ArrayList<D>();
		list.add(new D("hupan"));
		list.add(new D("robbin"));
		list.add(new D("jetman"));
		
		for (D d : list) {
			d.setName("*");
		}
		
		for (D d : list) {
			System.out.println(d.getName());
		}
	}
	
}

class D {
	String name;
	
	public D(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}