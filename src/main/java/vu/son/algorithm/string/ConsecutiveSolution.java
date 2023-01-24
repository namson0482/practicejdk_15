package vu.son.algorithm.string;

import java.util.Arrays;
import java.util.Scanner;

public class ConsecutiveSolution {
    int consecutive(int[] arr) {
        Arrays.sort(arr);

        int amount = 0;
        for (int i = 1; i < arr.length; i++) {
            amount += Math.abs(arr[i] - arr[i - 1]) - 1;
        }

        return amount;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        ConsecutiveSolution c = new ConsecutiveSolution();
        System.out.print(c.consecutive(new int[] {-2,10,4}));
    }
}
