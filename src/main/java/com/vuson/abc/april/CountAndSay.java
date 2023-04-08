package com.vuson.abc.april;

public class CountAndSay {


    public String countAndSay1(int n) {
        if (n == 1) {
            return "1"; //base case
        }
        String prev = countAndSay1(n - 1); //get the n-1 string
        //say n-1 string and store in the StringBuilder and return at the end
        StringBuilder sb = new StringBuilder();
        int numDigit = 1;
        char currentNum = prev.charAt(0); //storing the first digit in currentNum and it's count as 1 in numDigit
        for (int i = 1; i < prev.length(); i++) { //processing rest of the digits
            if (prev.charAt(i) == currentNum) {
                numDigit++;
            } else {
                sb.append(numDigit).append(currentNum);
                numDigit = 1;
                currentNum = prev.charAt(i);
            }
        }
        //append any digit is left to process
        if (numDigit > 0) {
            sb.append(numDigit).append(currentNum);
        }
        return sb.toString();
    }


    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String sTemp = countAndSay(n - 1);
        String ans = helper(sTemp);
        return ans;
    }

    private static String helper(String str) {
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            int count = 1;
            while (i > 0) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    i--;
                    count++;
                } else {
                    break;
                }
            }
            ans = Integer.toString(count) + str.charAt(i) + ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountAndSay count = new CountAndSay();
        String value = count.countAndSay(3);
        System.out.println(value);


    }
}
