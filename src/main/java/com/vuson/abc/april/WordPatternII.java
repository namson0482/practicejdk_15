package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Son Vu
 * @date Tue 2 May 2023
 */
@Slf4j
public class WordPatternII {
    public static boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        return help(pattern, s, 0, 0, map);

    }

    public static boolean help(String pattern, String s, int patternIndex, int sIndex, HashMap<Character, String> hashMap) {
        if (patternIndex == pattern.length() && sIndex == s.length()) { // if both are exactly 1 more than it's respective index,
            // that means they are all matched , so return true
            return true;
        }
        if (patternIndex == pattern.length() || sIndex == s.length()) {  // any other case is fail
            return false;
        }
        // Step (1)
        for (int i = sIndex; i < s.length(); i++) {
            char key = pattern.charAt(patternIndex); // The key is "a", or "b", then "a" again
            String value = s.substring(sIndex, i + 1);
            //Step (2)
            if (hashMap.get(key) == null) {
                if (hashMap.containsValue(value)) {
                    continue;
                }
                hashMap.put(key, value);
                if (help(pattern, s, patternIndex+1, i+1, hashMap)) {
                    return true;
                }
                hashMap.remove(key);
            }
            // Step(3) and (4)
            if (Objects.equals(hashMap.get(key), value)) {
                if (help(pattern, s, patternIndex+1, i+1, hashMap)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        WordPatternII wordPatternII = new WordPatternII();
        String pattern = "abab";
        String s = "redblueredblue";
        log.info(new WordPatternII().wordPatternMatch(pattern, s) + "");
    }
}
