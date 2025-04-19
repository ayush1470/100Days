/* LeetCode Problem: (561) Array Partition */

import java.util.*;

public class Day11Main{
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0; // Max Sum
        for(int i=0; i<nums.length; i+=2){ // i=i+2 as we want pairs
            sum += nums[i];  /* We aren't using Min as no need for that.
                                As we sorted in ascending order, so minimum of two
                                consecutive numbers will always be the first number.
                                (due to sorting) */
        }
        return sum;
    }

    public static void main(String[] args){
        int[] nums = {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums));
    }
}

/* Key Logic: To maximize the sum of min(a, b) for n pairs,
              we first sort the array. Then, for every pair,
              the smaller number will always be at the even index (i).
              Adding every element at even indices gives the maximum possible sum. */