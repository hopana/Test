package fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

public class TestJson {
	public static void main(String[] args) {
		Person p = new Person("PP", 20, "深圳福田");
		System.out.println(JSON.toJSONString(p));
		
		String s = "{name:'胡盼', age:20, addr:'深圳南山'}";
		Person person = JSONObject.parseObject(s, Person.class);
		System.out.println(person.name);
		
		JSONPObject jsonp = new JSONPObject("callback");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "hupan");
		map.put("age", "28");
		map.put("addr", "shenzhen");
		jsonp.addParameter(map);
		System.out.println(jsonp.toJSONString());
		
		String json = "[{name:'胡盼', age:20, addr:'深圳南山'},{name:'胡盼', age:20, addr:'深圳南山'}]";
		List<Person> list = JSONArray.parseArray(json, Person.class);
		System.out.println(list.get(0).getName());
		
		List<Person> plist = new ArrayList<Person>();
		plist.add(new Person("a", 1, "aa"));
		plist.add(new Person("b", 2, "bb"));
		plist.add(new Person("c", 3, "cc"));
		
		System.out.println(JSON.toJSONString(plist));
	}
	
}

class Person {
	String name;
	int age;
	String addr;
	
	public Person() {

	}

	public Person(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}