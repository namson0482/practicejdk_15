package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

    public List<String> generatePossibleNextMoves(String currentState) {
        int n= currentState.length();
        List<String> res = new ArrayList<>();
        for(int i=0;i<n-1;i++) {
            if(currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+') {
                String state = String.format("%s%s%s",currentState.substring(0,i), "--",currentState.substring(i+2, n));
                res.add(state);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "++++";
        List res = new FlipGame().generatePossibleNextMoves(input);
        res.forEach(System.out::println);
    }
}
