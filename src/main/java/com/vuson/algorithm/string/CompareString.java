package com.vuson.algorithm.string;

public class CompareString {
    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "abc";

        String str3 = "abc";

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equalsIgnoreCase(str3));


    }
}
