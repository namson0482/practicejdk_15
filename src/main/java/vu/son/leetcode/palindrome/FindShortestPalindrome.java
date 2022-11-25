package vu.son.leetcode.palindrome;

class FindShortestPalindrome {

    static boolean isPalin(char[] str, int st, int end) {
        while (st < end) {
            if (str[st] != str[end]) {
                return false;
            }

            st++;
            end--;
        }
        return true;
    }

    static int findMinInsert(char[] str, int n) {

        for (int i = n - 1; i >= 0; i--) {

            if (isPalin(str, 0, i)) {
                return (n - i - 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[] input = "abcd".toCharArray();
        System.out.println(
                findMinInsert(input, input.length));
    }
}

