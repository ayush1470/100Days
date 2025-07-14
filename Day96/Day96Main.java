/* LeetCode Problem: (1695): Maximum Erasure Value */

import java.util.HashSet;

public class Day96Main{
    public static int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int left = 0, sum = 0;
        int maxSum = 0;
        for(int right=0; right<nums.length; right++){
            while(seen.contains(nums[right]) && (left < right)){
                sum -= nums[left];
                seen.remove(nums[left]);
                left++;
            }
            seen.add(nums[right]);
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }
}