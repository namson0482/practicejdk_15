package vunam.array;

/**
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n))
 * @author son vu
 */
public class MergeArrayMedian {

    public double findMedianSortedArrays(int []nums1, int []nums2) {
        int []nums3 = new int[nums1.length + nums2.length];

        int i=0;
        int j=0;
        int k=nums3.length;
        for(int h=0;h<k;h++) {

            if(i<nums1.length && j < nums2.length) {
                if(nums1[i] <= nums2[j]) {
                    nums3[h] = nums1[i++];
                } else {
                    nums3[h] = nums2[j++];
                }
            } else {
                if(i == nums1.length) {
                    nums3[h] = nums2[j++];
                } else if(j == nums2.length) {
                    nums3[h] = nums1[i++];
                }
            }

        }
        if(nums3.length%2 != 0) {
            return nums3[nums3.length/2];
        }
        int index = nums3.length/2;
        return (nums3[index] + nums3[index-1]) * 1.0/ 2.0;
    }


    public static void main(String[] args) {
//        int []nums1 = {1, 3};
//        int []nums2 = {2};
        int []nums1 = {1, 2};
        int []nums2 = {3, 4};
        MergeArrayMedian mergeArrayMedian = new MergeArrayMedian();
        double result = mergeArrayMedian.findMedianSortedArrays(nums1, nums2);
        System.out.println("Value: " + result);
    }
}
