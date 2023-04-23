package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Rakuten {

    public static void main(String[] args) {
        String input = "A    B";
        String value = solution(input);
        log.info(value);
    }

    public static String solution(String input) {
        if (input == null || input.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        String[] arr = input.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if(temp.length()>0 && temp.charAt(0)>=65 && temp.charAt(0)<=96) {
                sb.append(temp.charAt(0));
            }
        }

        String[] values = Arrays.stream(arr).filter(v -> v.length() > 0)
                .map(v -> v.charAt(0) + "")
                .toArray(String[]::new);
        for (String item : values) {
            sb.append(item);

        }
        return sb.toString();
    }

}
