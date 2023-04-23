package vu.son.leetcode.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In the part, there are n friends standing in a random order, they plan to throw the ball around.
 * Each friend have a unique number in a range of 1 to n, inclusive. The friend always throw the ball toward the friend given at receiver[i]
 * and this will happen each second. Friend 1 always start with the ball, and a friend always throw the ball to another player.
 * Determine which friend has the ball after k second pass.
 */
public class ThrowTheBall {

    public static int throwTheBall(List<Integer> receiver,long seconds) {

        Map<Integer, Integer> map = new HashMap();
        int result = 1;
        int idx = 1;
        map.put(1, 1);
        for(int i=0;i<receiver.size();i++) {
            if(!map.containsKey(receiver.get(i))) {
                map.put(receiver.get(i), receiver.get(i));
                result = receiver.get(i);
            } else {
                if(map.get(receiver.get(i)) == 1) {
                    continue;
                }
            }
            idx++;
            if(idx == seconds) {
                break;
            }
            if(i == receiver.size() - 1) {
                i = -1;
                map = new HashMap();
                result = 1;
                map.put(1, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 1 - 6 - 2 - 5 - 3 - 2 - 5 - 3
        // 7
        // 3
//        Integer array[] = new Integer[]{6, 5, 2, 5, 3, 2};
//        long seconds = 7; //3

        Integer[] array = new Integer[]{2, 4, 1, 5, 3};
        long seconds = 6;  //2

        List<Integer> receiver = Arrays.asList(array);

        ThrowTheBall throwTemp = new ThrowTheBall();
        int result = throwTheBall(receiver, seconds);
        System.out.print("Value: ");
        System.out.println(result);
    }
}
