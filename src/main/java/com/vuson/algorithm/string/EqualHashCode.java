package com.vuson.algorithm.string;

public class EqualHashCode {

    public static void main(String[] args) {
		String s1 = "son";
		String s2 = "son";

        String s3 = s1.intern();
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
    }
}
