package utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * java实现对象转json
 * 
 * @author Mickey
 */
public class JsonUtils {

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
		int len = 0;
		if (array == null || (len = Array.getLength(array)) == 0) {
			return "[]";
		}
		
		StringBuilder json = new StringBuilder();
		
		json.append("[");
		for (int i = 0; i < len; ++i) {
			json.append(objectToJson(Array.get(array, i)));
			json.append(",");
		}
		json.setCharAt(json.length() - 1, ']');
		
		return json.toString();
	}

	/**
	 * @param map
	 * @return String
	 */
	public static String mapToJson(Map<?, ?> map) {
		if (map == null || map.size() == 0) {
			return "{}";
		}
		
		StringBuilder json = new StringBuilder();
		
		json.append("{");
		for (Object key : map.keySet()) {
			json.append(objectToJson(key));
			json.append(":");
			json.append(objectToJson(map.get(key)));
			json.append(",");
		}
		json.setCharAt(json.length() - 1, '}');
		
		return json.toString();
	}
	
	/**
	 * @param object
	 * @return String
	 */
	public static String collectionToJson(Object object) {
		if (object == null) {
			return "[]";
		}
		
		StringBuilder json = new StringBuilder();
		Collection<Object> collection = (Collection<Object>) object;
		
		json.append("[");
		if (collection.size() > 0) {
			for (Object obj : collection) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		
		return json.toString();
	}
}
