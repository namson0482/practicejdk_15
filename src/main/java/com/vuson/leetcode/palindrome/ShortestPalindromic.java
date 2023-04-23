package com.vuson.leetcode.palindrome;

/**
 * @author Son Vu
 * Add characters then let string become Palindrome
 */
public class ShortestPalindromic {

    public boolean isPalindrome(char[] str, int start, int end) {
        while (start < end) {
            if (str[start] != str[end]) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        for (int i = n/2 ; i >= 0; i--) {
            if (isPalindrome(str, 0, i)) {
                int min = n - i - 1;
                String temp = "";
                for(int k=s.length()-1;k>=s.length()-min;k--) {
                    temp += str[k];
                }
                return temp + s;
            }
        }
        return "";
    }

    // Driver Code
    public static final void main(String[] args) {
        String input = "abcda";

        System.out.println(new ShortestPalindromic().shortestPalindrome(input));

    }

}
