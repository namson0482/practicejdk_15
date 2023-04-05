package com.vuson.algorithm.codility;


/**
 * Charlemagne, the King of Frankia, is considering building some castles on the border with Servia.The border is divided into N segments.
 * The King know the height of the terrain in each segment of the border.
 * The height of each segment of terrain is stored in array A, with A[P] denoting the height of the P-th segment of the border.
 * The King decided to build a castle on top of every hill and in the bottom of every valley.
 * <p>
 * Let [P..Q] denote a group of consecutive segments from P to Q inclusive
 * such that (0 ≤ P ≤ Q  ≤ N-1). Segments P..O form a hill or a valley if all the following conditions are satisfied:
 * The terrain height of each segment from P to O is the same (AP|= AIP+1=
 * = AIOTE
 * If P > 0 then AlP-11 < AÍP] (for a hill) or A[P-11 > A[P] (for a vallev)
 * If 0 < N-1 then AlO+11 < AlOl (for a hill) or AlO+11 > Alol (for a vallev):
 * That is, a hill is higher than its surroundings and a valley is lower than its surroundings.
 * Note that if the surrounding on either side of the hill or valley don't exist (i.e. at the edaes
 * of the area under consideration. where rP=U00=N-Tthen the condition is considered
 * satisfied for that side of the hill/valley
 * The king is wondering how many castles is he going to build. Can you help him?
 * For example. consider the following arrav A = 2.2.3. 4.3.3.2.2.1.1.2.5
 * <p>
 * There are two hills: [3, 3] and [11, 11] There are also two valleys: [o.11 and [8, 9] There are no other suitable places for castles
 * Write a function
 * public int solution
 * that, given an array A consisting of N integers, as explained above, returns the total number of hills and valleys.
 * <p>
 * For example aiven arrav A as described above the function should return 4
 * <p>
 * Given array A = -3, -3 describing segments with a terrain height below 0, segment 0..1 forms botth a hill and a valley, and only  one castle can be build, so the function should return 1.
 */
public class Castle {

    public static void main(String[] args) {
//        int[] array = {2, 2, 3, 4, 3, 3, 3, 2, 1, 1, 2, 5};
        int[] array = {2, 2, 3, 4, 4};
        Castle c = new Castle();
        int res = c.wiggleMaxLength(array);
        System.out.println(res);
    }


    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int count = 1;
        int i = 0, j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[j] == nums[i]) {
                ++i;
                ++j;
            } else if (nums[j] > nums[i]) {
                ++count;
                int k = j + 1;
                while (k < nums.length && nums[k] >= nums[k - 1]) {
                    ++k;
                }
                if (k == nums.length)
                    return count;
                i = k - 1;
                j = k;
            } else {
                ++count;
                int k = j + 1;
                while (k < nums.length && nums[k] <= nums[k - 1]) {
                    ++k;
                }
                if (k == nums.length)
                    return count;
                i = k - 1;
                j = k;
            }
        }
        return count;
    }


}
