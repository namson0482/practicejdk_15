package vu.son.string;

<<<<<<<< HEAD:src/main/java/vunam/string/FindOccurrenciesInArray.java
package vunam.string;
========
package vu.son.string;
>>>>>>>> revert-7-beta:src/main/java/vu/son/string/FindOccurrenciesInArray.java

import java.util.*;
import java.util.stream.Collectors;

public class FindOccurrenciesInArray {

	
	public void findoutOccurrencies(String []inputs, int k) {
		
		Map<String, Integer> mapValues = new HashMap<String, Integer>() ;
		List<String> listValues = Arrays.asList(inputs);
		for(String value: listValues) {
			if(!mapValues.containsKey(value)) {
				mapValues.put(value, 1);
			} else {
				mapValues.replace(value, mapValues.get(value) + 1);
			}
		}
		mapValues = mapValues.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		
		for(Map.Entry<String, Integer> value : mapValues.entrySet()) {
			System.out.println(value.getKey() + ":" + value.getValue());
		}
	}
	
	public static void main(String[] args) {
		
		String []inputs = {"aa", "bb", "aa", "cc"};
		FindOccurrenciesInArray java = new FindOccurrenciesInArray();
		java.findoutOccurrencies(inputs, 2);
	}
	
}
