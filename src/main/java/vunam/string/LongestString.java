<<<<<<<< HEAD:src/main/java/vunam/string/LongestString.java
package vunam.string;
========
package vu.son.string;
>>>>>>>> revert-7-beta:src/main/java/vu/son/string/LongestString.java

import java.util.HashMap;
import java.util.Map;

public class LongestString {
	
	public static String findLongestString_1(String input) {
		
		int st, start, currentLength, maxLength ;
		
		st = start = currentLength = maxLength = 0;
		int i = 0;
		Map<Character, Integer> pos = new HashMap<Character, Integer>();
		
		for(i = 0;i<input.length();i++) {
			if(!pos.containsKey(input.charAt(i))) {
				pos.put(input.charAt(i), i);
			} else {
				if(pos.get(input.charAt(i)) >= st) {
					currentLength = i  - st;
					if(currentLength > maxLength) {
						maxLength = currentLength;
						start = st;
					}
					st = pos.get(input.charAt(i)) + 1;
				}
				pos.replace(input.charAt(i), i);
			}
		}
		
		if(i - st > maxLength) {
			maxLength = i - st;
			start = st;
		}
		return input.substring(start, start + maxLength);
	}

	public static String findLongestString(String input) {

		int i = 0;
		int st = 0, start = 0, maxLength = 0;
		int currentLength = 0;
		Map<Character, Integer> pos = new HashMap<Character, Integer>();

		pos.put(input.charAt(i), 0);
		for (i = 1; i < input.length(); i++) {
			if (!pos.containsKey(input.charAt(i))) {
				pos.put(input.charAt(i), i);
			} else {
				if (pos.get(input.charAt(i)) >= st) {
					currentLength = i - st;
					if (maxLength < currentLength) {
						maxLength = currentLength;
						start = st;
					}
					st = pos.get(input.charAt(i)) + 1;
				}
				pos.replace(input.charAt(i), i);
			}
		}

		if (maxLength < i - st) {
			maxLength = i - st;
			start = st;
		}

		return input.substring(start, start + maxLength);

	}

	public static void main(String[] args) {

		System.out.println("Hello Java 18");
		String input = "tikivn";
		System.out.println(findLongestString_1(input));

	}
}
