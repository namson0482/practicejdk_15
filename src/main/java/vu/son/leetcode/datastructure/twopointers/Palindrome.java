package vu.son.leetcode.datastructure.twopointers;

/**
 * @author: Son Vu
 * Check string If Palindrome then return true else return false
 */
public class Palindrome {

    public boolean checkIfPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().checkIfPalindrome("aba"));
    }
}
