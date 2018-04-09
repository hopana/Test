package test_java.stream;

import java.util.Arrays;

public class StreamTest {
	public static void main(String[] args) {
		String separator = ",";
		Arrays.asList("a", "b", "d").stream().forEach((String e) -> System.out.println(e + separator));
		
		System.out.println("---------------------");
		
		Arrays.asList("ac", "ab", "b", "d").stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
		
		System.out.println("---------------------");
		
		Arrays.asList("ac", "ab", "b", "d").stream().sorted().filter((s) -> s.startsWith("a")).forEach(System.out::println);
	}
}
