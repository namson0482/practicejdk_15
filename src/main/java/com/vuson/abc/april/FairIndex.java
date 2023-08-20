package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class FairIndex {
    public static int solution(List<Integer> a, List<Integer> b) {

        if(a == null || b == null || a.size() < 2 || a.size() != b.size())
            return 0;

         int []A = a.stream().mapToInt(q->q).toArray();
         int []B = b.stream().mapToInt(q->q).toArray();

        int sumArrayOne = 0;
        int sumArrayTwo = 0;
        int length = A.length;
        int k = 0 ;
        while(k<length) {
            sumArrayOne += A[k];
            sumArrayTwo += B[k];
            k++;
        }
        int count = 0;
        int tempArrayOne = A[0];
        int tempArrayTwo = B[0];

        k = 1;
        while(k<length) {
            if (k != 1) {
                if (tempArrayOne == tempArrayTwo && 2*tempArrayOne == sumArrayOne && tempArrayTwo * 2 == sumArrayTwo)
                    count++;
            }
            tempArrayOne += A[k];
            tempArrayTwo += B[k];
            k++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        int []array1 = new int[]{0, 2};
        int []array2 = new int[]{0, 2};

        log.info(solution(Arrays.stream(array1).boxed().collect(Collectors.toList())
                , IntStream.of(array2).boxed().collect(Collectors.toList())) + "");

//        Scanner scanner = new Scanner(System.in);
//        int[] A1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] B1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(solution(A1, B1));
    }
}
