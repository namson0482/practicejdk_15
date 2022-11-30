package vu.son.leetcode.string;

public class ZigZag {

    //P     A       Y       P       A       L       I       S       H       I       R       I       N       G
    //0     1       2       3       4       5       6       7       8       9       10      11      12      13


    public static String convert(String s, int numRows) {
        if(s.length() == 1) {
            return s;
        }
        String ans = "";
        int space = numRows * 2 - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += space) {
                ans += s.charAt(i + j);
                if (i != 0 && i != numRows - 1 && j - i + space < s.length()) {
                    ans += s.charAt(j + space - i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        System.out.println(ZigZag.convert(input, 4));
    }
    // PINALSIGYAHPI
    //"PINALSIGYAHRPI"
}
