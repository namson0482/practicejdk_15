package vu.son.leetcode.leastrecentused;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LeastRecentUsed {

    LinkedHashMap<String, String> cache ;

    int capacity;

    public LeastRecentUsed(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }

    public boolean get(String key) {
        if(!cache.containsKey(key)) {
            return false;
        }
        String value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return true;
    }

    public void put(String key, String value) {
        if(!get(key)) {
            if(capacity == cache.size()) {
                String firstKey = cache.keySet().iterator().next();
                cache.remove(firstKey);
            }
            cache.put(key, value);
        }
    }

    public void printValues() {

        System.out.println("");
        System.out.print("Values: ");
        LinkedList linkedList = new LinkedList(cache.keySet());
        Iterator iterator = linkedList.descendingIterator();
        while(iterator.hasNext()) {
            String value = (String)iterator.next();
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        LeastRecentUsed leastRecentUsed = new LeastRecentUsed(4);
        leastRecentUsed.put("1", "1");
        leastRecentUsed.put("2", "2");
        leastRecentUsed.put("3", "3");
        leastRecentUsed.put("4", "4");
        leastRecentUsed.printValues();
    }
}
