/* LeetCode Problem: (1658) Minimum Operations to Reduce X to Zero */

public class Day37Main{
    public static int minOperations(int[] nums, int x){
        int total = 0;
        for(int num : nums){
            total += num;
        }
        int target = total - x;
        if(target < 0) return -1;
        if(target == 0) return nums.length;

        int maxLen = -1, sum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum > target && left <= right){
                sum -= nums[left++];
            }
            if(sum == target){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return (maxLen == -1) ? -1 : nums.length - maxLen;
    }

    public static void main(String[] args){
        int[] nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(nums, x));
    }
}

/* Key Logic: - Instead of greedily removing elements from the left or right to reach x,
                we reframe the problem: find the longest subarray whose sum is totalSum - x.
              - Keeping this subarray means removing the rest (from both ends),
                so the minimum number of operations = total length - length of that subarray.
              - If no such subarray exists, return -1. */
