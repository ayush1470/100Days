/* LeetCode Problem: (53) Maximum Subarray */

public class Day20Main{
    public static int maxSubArray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = 0;
        for(int num : nums){
            currentSum += num;
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}


/* Key Logic: - This is Kadane's Algorithm for finding the maximum sum subarray in O(n) time.
              - We iterate through the array, maintaining a running sum (currentSum).
              - If currentSum becomes greater than maxSum, we update maxSum.
              - If currentSum drops below 0, we reset it to 0, because any negative sum won't
                help in building a larger subarray ahead.
              - maxSum always holds the maximum sum encountered so far.
              - This greedy approach ensures we don't consider subarrays with negative prefixes. */