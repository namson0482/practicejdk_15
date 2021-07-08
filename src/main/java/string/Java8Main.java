package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Main {

	
	// simple check against empty strings
//	public static int check(String s) {
//	    if (s.equals("")) {
//	        throw new IllegalArgumentException();
//	    }
//	    return s.length();
//	}
	
	public void practiceStream() {
		
		List<Integer> listValue = new ArrayList<Integer>();
		listValue.add(1);
		listValue.add(2);
		listValue.add(4);
		listValue.add(10);
		listValue.add(6);
		listValue = listValue.parallelStream().sorted().collect(Collectors.toList());
		
		listValue.forEach(System.out::println);
		listValue.forEach(x -> System.out.println(x));
	}
	  
	public static void main(String[] args) {
		
		//map names to lengths
//		String []inputs = {"", "1"};
//		List<String> names = Arrays.asList(inputs);
		
		String str_3 = new String("namson");
		String str_1 = "namson";
		String str_2 = str_3.intern();
		
		System.out.println(str_1.hashCode() == str_2.hashCode());
		System.out.println(str_1 == str_3);
		System.out.println(str_1.equals(str_3));
		
//		Java8Main java8 = new Java8Main();
//		java8.practiceStream();
		
	}
}
