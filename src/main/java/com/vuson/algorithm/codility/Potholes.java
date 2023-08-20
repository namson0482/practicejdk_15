package com.vuson.algorithm.codility;

import java.util.PriorityQueue;

public class Potholes {

    public static int solution(String S, int B) {

        PriorityQueue<Integer> numOfConsecutivePotHoles = new PriorityQueue<>((a, b) -> b - a);
        int countCurrPothole = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'x') {
                countCurrPothole++;
            } else {
                if (countCurrPothole != 0) {
                    numOfConsecutivePotHoles.add(countCurrPothole);
                    countCurrPothole = 0;
                }
            }
        }
        if (countCurrPothole != 0) {
            numOfConsecutivePotHoles.add(countCurrPothole);
        }

        int budget = B;
        int countFixableHoles = 0;
        while (!numOfConsecutivePotHoles.isEmpty() && budget > 0) {
            int numConsecutivePotholes = numOfConsecutivePotHoles.poll();
            if (numConsecutivePotholes + 1 <= budget) {
                countFixableHoles = countFixableHoles + numConsecutivePotholes;
                budget = budget - (numConsecutivePotholes + 1);
            } else {
                budget = budget - 1;
                countFixableHoles += budget;
                budget = 0;
            }
        }

        return countFixableHoles;

    }

    public static void main(String[] args) {
        Potholes potholes = new Potholes();
        String s = "...xxx..x.....xxx";
        int B = 7;
        int result = solution(s, B);
        System.out.println(result);
    }

}
