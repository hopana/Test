package json;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

/**
 * 原生java代码实现对象转json
 * 
 * @author Mickey
 */
public class JsonUtils3 {

	public static String objectToJson(Object obj) {
		StringBuilder json = new StringBuilder();
		
		if (obj == null || obj instanceof Number || obj instanceof Boolean) {
			json.append(obj);
		} else if (obj instanceof String) {
			json.append("\"").append(obj).append("\"");
		} else if (obj.getClass().isArray()) {
			json.append(arrayToJson(obj));
		} else if (obj instanceof Collection) {
			json.append(collectionToJson(obj));
		} else if (obj instanceof Map) {
			json.append(mapToJson((Map<?, ?>) obj));
		} else {
			json.append(beanToJson(obj));
		}
		
		return json.toString();
	}

	/**
	 * @param bean
	 * @return String
	 */
	public static String beanToJson(Object bean) {
		StringBuilder json = new StringBuilder();
		
		json.append("{");
		
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod().invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		
		return json.toString();
	}
	
	/**
	 * @param array
	 * @return String
	 */
	public static String arrayToJson(Object array) {
		StringBuilder json = new StringBuilder();
		
		json.append("[");
		
		int len = 0;
		if (array != null && (len = Array.getLength(array)) > 0) {
			for (int i = 0; i < len; ++i) {
				json.append(Array.get(array, i));
				json.append(",");
			}
			
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		
		return json.toString();
	}

	/**
	 * @param map
	 * @return String
	 */
	public static String mapToJson(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		
		json.append("{");
		
		if (map != null && map.size() > 0) {
			for (Object key : map.keySet()) {
				json.append(objectToJson(key));
				json.append(":");
				json.append(objectToJson(map.get(key)));
				json.append(",");
			}
			
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		
		return json.toString();
	}

	/**
	 * @param object
	 * @return String
	 */
	public static String collectionToJson(Object object) {
		StringBuilder json = new StringBuilder();
		
		json.append("[");
		
		if (object != null) {
			Collection<Object> collection = (Collection<Object>) object;
            for (Object item : collection) {
            	json.append(objectToJson(item));
            	json.append(",");
            }
            
            json.setCharAt(json.length() - 1, ']');
        } else {
			json.append("]");
		}
		
		return json.toString();
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3};
		
		List<String> list = new ArrayList<String>();
		list.add("11");
		list.add("22");
		list.add("33");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(11, "aa");
		map.put(22, "bb");
		map.put(33, "cc");
		
		Set<String>  set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		
		System.out.println(arrayToJson(null));
		System.out.println(mapToJson(null));
		System.out.println(collectionToJson(null));
		System.out.println(collectionToJson(null));
		
		System.out.println(JSON.toJSON(new Worker("mike", 25, true, Collections.emptyList(), Collections.emptyMap(), new int[0])));
	}
	
}

class Worker {
	String name;
	int age;
	boolean isMale;
	
	List list;
	Map map;
	int[] arr;
	
	public Worker() {

	}

	public Worker(String name, int age, boolean isMale, List list, Map map, int[] arr) {
		this.name = name;
		this.age = age;
		this.isMale = isMale;
		this.list = list;
		this.map = map;
		this.arr = arr;
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

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
}
