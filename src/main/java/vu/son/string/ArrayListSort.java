package vu.son.string;

<<<<<<<< HEAD:src/main/java/vunam/string/ArrayListSort.java
package vunam.string;
========
package vu.son.string;
>>>>>>>> revert-7-beta:src/main/java/vu/son/string/ArrayListSort.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListSort {
	
	
	public static void sortByCollections () {
		
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		arraylist.add(11);
		arraylist.add(2);
		arraylist.add(7);
		arraylist.add(3);
		/* ArrayList before the sorting */
		System.out.println("Before Sorting:");
		for (int counter : arraylist) {
			System.out.println(counter);
		}
		Collections.sort(arraylist);
		arraylist.forEach(System.out::println);
		
	}
	
	public static void sortByJava8() {
		
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		arraylist.add(11);
		arraylist.add(2);
		arraylist.add(7);
		arraylist.add(3);
		
		arraylist.sort((e1, e2) -> e1.compareTo(e2));
		String value = Arrays.toString(arraylist.toArray());
		System.out.println(value);
	}
	
	public static void main(String args[]) {
		
		sortByJava8();

	}
}
