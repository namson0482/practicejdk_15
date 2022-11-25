package vu.son.string;

<<<<<<<< HEAD:src/main/java/vunam/string/WordBreakIII.java
package vunam.string;
========
package vu.son.string;
>>>>>>>> revert-7-beta:src/main/java/vu/son/string/WordBreakIII.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreakIII {

//	public static HashMap<String, String> getMinWords(String s, List<String> dict) {
//		
//		HashMap<String, HashMap<String, String>> mapValue = new HashMap<>();
//		HashMap<String, String> returnList = getMinWordsHelper(s, dict, mapValue);
//		mapValue.entrySet().forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));
//		return returnList;
//	}
	
	public static List<String> getMinWords(String s, List<String> dict) {
        return getMinWordsHelper(s, dict, new HashMap<>());
    }
	

//	private static HashMap<String, String> getMinWordsHelper(String s, List<String> dict, HashMap<String, HashMap<String, String>> memo) {
//
//		if (s == null || s.length() == 0)
//			return new HashMap<String, String>();
//
//		HashMap<String, String> result = null;
//		for (int i = 0; i < s.length(); i++) {
//			String substring = s.substring(0, i + 1);
//			if (dict.contains(substring)) {
//				HashMap<String, String> restResult = getMinWordsHelper(s.substring(i + 1), dict, memo);
//				if (restResult != null) {
//					restResult.put(substring, substring);
//					if (memo.get(s) != null) {
//						if (memo.get(s).size() > restResult.size()) {
//							memo.put(s, restResult);
//							result = restResult;
//						}
//					} else {
//						memo.put(s, restResult);
//						result = restResult;
//					}
//				}
//			}
//		}
//		memo.put(s, result);
//		return result;
//	}
	
	
	 private static List<String> getMinWordsHelper(String s, List<String> dict, HashMap<String, List<String>> memo) {

	        if (s == null || s.length() == 0) return new ArrayList<>();

	        List<String> result = null;
	        for (int i = 0; i < s.length(); i++) {
	            String substring = s.substring(0, i + 1);
	            if (dict.contains(substring)) {
	                List<String> restResult = getMinWordsHelper(s.substring(i + 1), dict, memo);
	                if (restResult != null) {
	                    restResult.add(substring);
	                    if (memo.get(s) != null) {
	                        if (memo.get(s).size() > restResult.size()) {
	                            memo.put(s, restResult);
	                            result = restResult;
	                        }
	                    } else {
	                        memo.put(s, restResult);
	                        result = restResult;
	                    }
	                }
	            }
	        }
	        memo.put(s, result);
	        return result;
	    }

//	public boolean checkStrValid(String s, List<String> dict, HashMap<String, HashMap<String, String>> memo) {
//
//		HashMap<String, String> result = getMinWordsHelper(s, dict, memo);
//		return result == null ? false : true;
//	}

	public static void main(String[] args) {
	
//		result2.forEach(System.out::println);
		
//		HashMap<String, String>result2 = getMinWords("catdog", Arrays.asList("cat", "dog"));
//		HashMap<String, String>result2 = getMinWords("catsanddogcatsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
//		if(result2	!= null)
//			result2.entrySet().forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));
		
		List<String> result2 = getMinWords("catsanddogcatsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
		if (result2 == null) {
			System.out.println("null");
		} else {
			result2.forEach(System.out::println);

		}
	}
}
