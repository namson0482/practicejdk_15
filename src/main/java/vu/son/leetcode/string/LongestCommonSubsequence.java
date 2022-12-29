package vu.son.leetcode.string;

/**
 * https://www.programiz.com/dsa/longest-common-subsequence
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */

public class LongestCommonSubsequence {

    int[][] dynamicProgramming;

    public int longestCommonSubsequence(String text1, String text2) {
        if (text2.length() == 0 || text1.length() == 0) {
            return 0;
        }
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();

        dynamicProgramming = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i < s1.length; i++) {
            System.out.println("i="+i);
            for (int j = 0; j < s2.length; j++) {
                System.out.println("j="+j);
                if (s1[i] == s2[j]) {
                    dynamicProgramming[i+1][j+1] = dynamicProgramming[i][j] + 1;
                } else {
                    dynamicProgramming[i+1][j+1] = Math.max(dynamicProgramming[i][j+1], dynamicProgramming[i+1][j]);
                }
            }
        }
        return dynamicProgramming[s1.length][s2.length];
    }


    public static void main(String[] args) {
        String text1 = "oxcpqrsvwf";
        String text2 = "shmtulqrypy";

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
    }

}
