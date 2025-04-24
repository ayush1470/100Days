/* LeetCode Problem: (977) Squares of a Sorted Array */

import java.util.*;

public class Day16Main{
    public static int[] getSquaresOfSortedArray(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n-1;
        int idx = n-1; // we will start from last.
        while(left <= right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            if(leftSquare > rightSquare){
                result[idx--] = leftSquare;  /* We find which element is maximum after square as we start
                                                filling from last position [beginning or the end one
                                                as array is sorted] (Take example to understand) */
                left++;
            }else{
                result[idx--] = rightSquare;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {-5, -3, -1, 0, 1, 4, 10};
        System.out.println(Arrays.toString(getSquaresOfSortedArray(nums)));
    }
}

/* Key Logic: We are using the two-pointer approach here. Why we are using it is
              because "Use two pointers when a sorted array needs to be processed
              from both ends — and you don’t want to sort again".
              - Since the input array is sorted, the largest square value will be either
                at the start or end.
              - Use two pointers (left and right) to compare absolute values.
              - Place the larger square at the end of the result array and move the respective
                pointer inward.
              - This avoids sorting and builds the output in O(n) time.

              HINT: Array ke ek ek element ko ek baar sort karke dekho ki array
              dikh kaisi rhi hai, tab easy hoga understand karna Two-Pointer ko. */
