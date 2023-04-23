package com.vuson.abc.april;

import java.util.*;

public class GetFactors {

    public List<List<Integer>> getFactors(int n) {
        final List<List<Integer>> ans = new LinkedList<>();
        final Stack<LinkedList<Integer>> stack = new Stack<>();
        stack.push(new LinkedList<>(new LinkedList<>(List.of(n))));
        while (!stack.isEmpty()) {
            final LinkedList<Integer> factors = stack.pop();
            final int lastFactor = factors.removeLast();
            for (int i = factors.isEmpty() ? 2 : factors.peekLast(); i <=  lastFactor / i; ++i) {
                if (lastFactor % i == 0) {
                    // Add i and lastFactor / i.
                    LinkedList<Integer> newFactors = new LinkedList<>(factors);
                    newFactors.add(i);
                    newFactors.add(lastFactor / i);
                    stack.push(newFactors);
                    ans.add(new LinkedList<>(newFactors));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GetFactors factors = new GetFactors();
        List list = factors.getFactors(12);
        list.forEach(System.out::println);
    }
}
