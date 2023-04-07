package com.vuson.abc.april;

public class GetMissingNumber {

    public static int getMissingNumber(int[] numbers) {

        int result = -1;
        for(int i=1;i<=100;i++) {
            boolean find = false;
            for(int j=0;j<numbers.length;j++) {
                if(numbers[j] == i) {
                    find = true;
                    break;
                }
            }
            if(find == false) {
                return i;
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }


}
