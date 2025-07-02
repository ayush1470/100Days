/* LeetCode Problem: (4): Median of Two Sorted Arrays */

import java.util.Arrays;

public class Day84Main{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merge = new int[m+n];
        for(int i=0; i<nums1.length; i++){
            merge[i] = nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            merge[m+i] = nums2[i];
        }
        Arrays.sort(merge);
        int mid = (merge.length)/2;
        double res = 0.0;
        if(merge.length % 2 != 0){
            return (double) merge[mid];
        }else{
            res = (double) (merge[mid-1] + merge[mid])/2;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

/* Key Logic:
1. We are given two sorted arrays (nums1 and nums2).
2. First, we merge both arrays into a new array called 'merge'.
   - The first for-loop copies all elements of nums1.
   - The second for-loop appends all elements of nums2.
3. We sort the merged array.
4. To find the median:
   - If the total number of elements is odd, the median is the middle element.
   - If even, it's the average of the two middle elements.
5. Finally, we return the median as a double value.

Points:
- Time Complexity: O((m + n) log(m + n)) due to sorting.
- Space Complexity: O(m + n) because we use an extra array to merge.
- This is a simple but not the most optimal solution (binary search can do better in O(log(min(m, n)))). */
