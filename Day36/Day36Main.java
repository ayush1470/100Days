/* LeetCode Problem: (209) Minimum Size Subarray Sum */

public class Day36Main{
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right=0; right<nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args){
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}

/* Key Logic: - Use a sliding window approach with two pointers: `left` and `right`.
              - Expand the window by moving `right` and adding `nums[right]` to `sum`.
              - Once `sum` becomes greater than or equal to `target`, try to shrink the window
                from the left to find the smallest possible subarray length while maintaining the
                condition.
              - Track the minimum length of all valid windows.
              - If no valid subarray is found, return 0. */