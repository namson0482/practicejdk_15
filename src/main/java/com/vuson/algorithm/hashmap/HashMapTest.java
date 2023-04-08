package com.vuson.algorithm.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapTest {
	
	public static void checkHashMap() {
		
		Map<String, Integer> unsortedMap = new HashMap<String, Integer>();
		unsortedMap.put("John", 21);
		unsortedMap.put("Maria", 34);
		unsortedMap.put("Mark", 31);
		unsortedMap.put("Sydney", 24);
		
//		Map<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
//		    @Override
//		    public int compare(String o1, String o2) {
//		        int lengthDifference = o1.length() - o2.length();
//		        if (lengthDifference != 0) return lengthDifference;
//		        return o1.compareTo(o2);
//		    }
//		});
//
//		sortedMap.putAll(unsortedMap);
//		sortedMap.entrySet().forEach(System.out::println);
		
//		.sorted(Map.Entry.comparingByKey())
		
		Map<String, Integer> sortedMap = unsortedMap.entrySet().stream()
		        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
		        .collect(Collectors.toMap(
		                Map.Entry::getKey,
		                Map.Entry::getValue,
		                (a, b) -> { throw new AssertionError(); },
		                LinkedHashMap::new
		        ));

		sortedMap.entrySet().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		checkHashMap();
	}
	
	private String MY_NAME = "name";

	private String STR_SALT = "salt";
	
	public HashMapTest() {
		
		this.STR_SALT = "salt_test";
		this.MY_NAME = "name_value";
	}
}
