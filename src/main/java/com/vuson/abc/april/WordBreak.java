package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
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



    public void wordBreakII(String input, List<String> listDict,List<List<String>> listResult, List<String> listTemp, int start) {
        if(start == input.length()) {
            listResult.add(new ArrayList<>(listTemp));
        }
        for(int end=start+1;end<input.length()+1;end++) {
            String subString = input.substring(start, end);
            if(listDict.contains(subString)) {
                listTemp.add(subString);
                wordBreakII(input, listDict, listResult, listTemp, end);
                listTemp.remove(listTemp.size()-1);
            }
        }
    }


    public List<String>  doWordBreak(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        List<String> listTemp = new ArrayList<>();
        wordBreakII(s,wordDict,result, listTemp,0);

        List<String> res = new ArrayList<>();

        result.forEach(v -> {
            String sTemp = "";
            for(String item: v) {
                sTemp += item + " ";
            }
            sTemp = sTemp.trim();
            res.add(sTemp);
        });
        return res;
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("cat","cats","and","sand","dog");
        String s = "catsanddog";
//        List<String> list = Arrays.asList(new String[]{"apple","pen","applepen","pine","pineapple"});
//        String s = "pineapplepenapple";
        System.out.println(wordBreakDynamic(s, list));
//        doWordBreak(s, list);


    }
}
