<<<<<<<< HEAD:src/main/java/vunam/Java15Function.java
package vunam;
========
package vu.son.basic;
>>>>>>>> revert-7-beta:src/main/java/vu/son/basic/Java15Function.java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Java15Function {
	
	
	public static void checkFunction() {
		
		Function<String, Integer> function  = x -> x.length();
		
		Integer apply = function.apply("namson1");
		
		System.out.println(apply);
	}
	
	public static void checkFunctionAndThen() {
		
		Function<String, Integer>  function_1 = x -> x.length();
		
		Function <Integer, Integer> function_2 = x -> x * 2;
		
		Integer apply = function_1.andThen(function_2).apply("namson");
		
		System.out.println(apply);
	}
	
	public static void checkForEach() {
		
		String []array = {"1", "2", "3"};
		List<String> listString = Arrays.asList(array);
		
		Consumer<String> consumer = System.out::println;
		listString.forEach(consumer);
	}
	
	public static void main(String[] args) {
		
		checkForEach();
	}
}
