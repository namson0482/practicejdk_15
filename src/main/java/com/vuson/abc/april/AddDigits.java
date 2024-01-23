package com.vuson.abc.april;

public class AddDigits {

    public int addDigits(int num) {
        while(num>9) {
            String temp = num + "";
            int total = 0;
            for(int i=0;i<temp.length();i++) {
                total += temp.charAt(i) - '0';
            }
            num = total;
        }
        return num;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 97;
        int res = new AddDigits().addDigits(num);
        System.out.println(res);
    }
}
