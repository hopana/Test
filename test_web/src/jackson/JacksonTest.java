package jackson;

import org.codehaus.jackson.map.util.JSONPObject;

import com.alibaba.fastjson.JSONObject;

public class JacksonTest {
	public static void main(String[] args) {
		JSONPObject json = new JSONPObject("jack", new Jack("jack", "shenzhen", "male", 28));
		System.out.println(JSONObject.toJSON(json));
	}
}

class Jack {
	public Jack() {
		
	}
	
	public Jack(String name, String addr, String gender, int age) {
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.age = age;
	}



	String name;
	String addr;
	String gender;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}