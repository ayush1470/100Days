/* LeetCode Problem: (1004) Max Consecutive Ones III */

public class Day57Main{
    public static int longestOnes(int[] nums, int k){
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        // Use sliding window approach
        for (int right = 0; right < nums.length; right++){
            // Expand window by including current element
            if (nums[right] == 0){
                zeroCount++;
            }

            // Shrink window from left if we have more than k zeros
            while (zeroCount > k){
                if (nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            // Update maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args){
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        System.out.println("Test 1: " + longestOnes(nums1, k1)); // Expected: 6
    }
}

/* Key Logic: - Use sliding window (two pointers) technique to find maximum window with at most k zeros
              - Right pointer expands window, left pointer contracts when constraint violated
              - Track zero count in current window to maintain k constraint
              - Window size = right - left + 1, keep track of maximum valid window size */