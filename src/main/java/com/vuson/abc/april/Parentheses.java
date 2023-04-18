package com.vuson.abc.april;

import java.util.Stack;

public class Parentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (stack.peek() != -1 && s.charAt(stack.peek()) == '(' && s.charAt(i) == ')'){
                stack.pop();
                answer = Math.max(answer, i - stack.peek());
            } else {
                stack.push(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String parentheses = "((())(((";
//        String parentheses = "()(()";

        Parentheses object = new Parentheses();
        System.out.println(object.longestValidParentheses(parentheses));
    }
}
