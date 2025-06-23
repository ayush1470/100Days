/* LeetCode Problem: (2966): Divide Array Into Arrays With Max Difference */

import java.util.Arrays;

public class Day76Main{
    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] res = new int[n/3][3];
        Arrays.sort(nums);
        for(int i=0; i<n; i+=3){
            int a = nums[i], b = nums[i+1], c = nums[i+2];
            int diff1 = b - a, diff2 = c - b, diff3 = c - a;
            if(diff1 > k || diff2 > k || diff3 > k){
                return new int[0][0];
            }
            res[i/3][0] = a;
            res[i/3][1] = b;
            res[i/3][2] = c;
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        System.out.println(Arrays.deepToString(divideArray(nums,k)));
    }
}

/* Key Logic:
 - Sort the input array to make grouping similar elements easier.
 - Since n is guaranteed to be a multiple of 3, try to form groups of 3 consecutive elements.
 - For each group of 3, check if the difference between the smallest and largest element is <= k.
   (Since the array is sorted, this is simply nums[i+2] - nums[i])
 - If any group violates this condition, return an empty array as the division is invalid.
 - Otherwise, store each valid group into the result array. */
