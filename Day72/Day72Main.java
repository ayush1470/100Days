/* LeetCode Problem: (189): Rotate Array */

import java.util.Arrays;

public class Day72Main{
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n; /* for cases when k > n (hum k % n = jo bhi answer ae utne baar rotate
                      kar rhe hai instead of k times which has extra steps
                      (see an example like for n=5 and k = 7) */
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public static void reverse(int[] nums, int start, int end){
        while(start< end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

/* Key Logic: - The rotation is done in three steps using array reversal:
                 - Reverse the entire array.
                 - Reverse the first k elements.
                 - Reverse the remaining (n - k) elements.
              - This effectively shifts all elements k steps to the right. */