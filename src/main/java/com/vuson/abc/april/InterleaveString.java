package com.vuson.abc.april;

public class InterleaveString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;

        boolean[][] dynamicProgramming = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dynamicProgramming[i][j] = true;
                } else if (i == 0) {
                    dynamicProgramming[i][j] = dynamicProgramming[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dynamicProgramming[i][j] = dynamicProgramming[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);

                } else {
                    dynamicProgramming[i][j] = (dynamicProgramming[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                            || (dynamicProgramming[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dynamicProgramming[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        InterleaveString interleaveString = new InterleaveString();
        String s1 = "12";
        String s2 = "45";
        String s3 = "1425";
        System.out.println(interleaveString.isInterleave(s1, s2, s3));
    }


}
