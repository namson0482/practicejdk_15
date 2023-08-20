package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LetterCombinationPhoneNumber {


    public List<String> letterCombinations1(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }


    String[] arr = new String[]{"1", "2", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        StringBuilder sb = new StringBuilder();
        backtrack2(list, digits, sb, 0);
        return list;
    }

    private void backtrack2(List<String> list, String str, StringBuilder sb, int index) {
        if (sb.length() == str.length()) {
            list.add(sb.toString());
        } else {
            int val = str.charAt(index) - '0';
            for (int i = 0; i < arr[val].length(); i++) {
                sb.append(arr[val].charAt(i));
                backtrack2(list, str, sb, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        StringBuilder sb = new StringBuilder();
        backtrack(list, digits, sb, 0);
        return list;

    }

    public void backtrack(List<String> res, String digits, StringBuilder sb, int index) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
        } else {
            int val = digits.charAt(index) - '0';
            for(int i=0;i<arr[val].length();i++) {
                sb.append(arr[val].charAt(i));
                backtrack(res, digits, sb, index+1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationPhoneNumber letterCombinationPhoneNumber = new LetterCombinationPhoneNumber();
        List<String> res = letterCombinationPhoneNumber.letterCombinations("27");
        System.out.println(res);
    }

}
