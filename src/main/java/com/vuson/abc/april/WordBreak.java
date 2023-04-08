package com.vuson.abc.april;

import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String word, List<String> listWord) {
        return wordBreakRecur(word, new HashSet(listWord), 0);
    }

    private static boolean wordBreakRecur(String word, HashSet wordSet, int start) {
        if(start == word.length()) {
            return true;
        }

        for(int end=start+1;end<=word.length();end++) {
            String subString = word.substring(start, end);
            if(wordSet.contains(subString) && wordBreakRecur(word, wordSet, end))
                return true;
        }
        return false;
    }


    public static boolean wordBreakDynamic(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subString = s.substring(j, i);
                if (dp[j] && wordDictSet.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }





    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"c" , "ars"});
        String s = "cars";
        System.out.println(wordBreakDynamic(s, list));
    }
}
