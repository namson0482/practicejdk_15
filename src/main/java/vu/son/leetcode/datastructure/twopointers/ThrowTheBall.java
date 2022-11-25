package vu.son.leetcode.datastructure.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThrowTheBall {

    public static int throwTheBall(List<Integer> receiver,long seconds) {

        List<Integer> tempReceiver = new ArrayList<>();
        for(int i=0;i<receiver.size();i++) {
            if(receiver.get(i) != 1) {
                tempReceiver.add(receiver.get(i));
            }
        }
        tempReceiver.add(1);
        if(tempReceiver.size() >= seconds) {
            int temp = (int)seconds;
            return (int)tempReceiver.get(temp - 1);
        } else {
            long longTemp = seconds;
            while(longTemp > tempReceiver.size()) {
                longTemp = longTemp - tempReceiver.size();
            }
            int temp = (int)longTemp;
            return tempReceiver.get(temp - 1);
        }
    }

    public static void main(String[] args) {
        // 1 - 6 - 2 - 5 - 3 - 2 - 5 - 3
        // 7
        // 3
        // Second 	    Has ball	    Receiver
        // 1            1                6
        // 2            6                5
        // 3            5                2
        // 4            2                5
        // 5            5                3
        // 6            3                2
        // 7            2
        Integer array[] = new Integer[]{6, 5, 2, 5, 3, 2};
        long seconds = 5;

        List<Integer> receiver = Arrays.asList(array);

        ThrowTheBall throwTemp = new ThrowTheBall();
        int result = throwTemp.throwTheBall(receiver, seconds);
        System.out.println("Value: ");
        System.out.println(result);
    }
}
