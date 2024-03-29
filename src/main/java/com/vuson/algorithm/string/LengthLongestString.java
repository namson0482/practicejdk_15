package com.vuson.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class LengthLongestString {
	
	public static String longestStringUnique(String input) {
		
		int st = 0 , start = 0;
		int maxLength = 0, currentLength = 0;
		var pos = new HashMap<Character, Integer>();
		int i = 0;
		for(i=0;i<input.length();i++) {
			if(!pos.containsKey(input.charAt(i))) {
				pos.put(input.charAt(i), i);
			} else {
				if(pos.get(input.charAt(i)) >= st) {
					currentLength = i - st;
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
		return input.substring(start, maxLength + start);
	}

	static int longestUniqueSubsttr(String s) {

		// Creating a set to store the last positions of occurrence
		HashMap<Character, Integer> seen = new HashMap<>();
		int maximum_length = 0;

		// starting the inital point of window to index 0
		int start = 0;

		for (int end = 0; end < s.length(); end++) {
			// Checking if we have already seen the element or not
			if (seen.containsKey(s.charAt(end))) {
				// If we have seen the number, move the start pointer
				// to position after the last occurrence
				start = seen.get(s.charAt(end)) + 1;
			}

			// Updating the last seen value of the character
			seen.put(s.charAt(end), end);
			maximum_length = Math.max(maximum_length, end - start + 1);
		}
		return maximum_length;
	}

	// Driver code
	public static void main(String[] args) {
		
 		String s = "tikivn";
		System.out.println("The input String is " + s);
		String res = longestStringUnique(s);
		System.out.println("The length of the longest non-repeating character substring is " + res);
	}
}
