/* LeetCode Problem: (525) Contiguous Array */

import java.util.*;

public class Day42Main{
    public static int findMaxLength(int[] nums) {
        // Convert 0s to -1s
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        // Map to store first occurrence of cumulative sum
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case for subarrays starting from index 0

        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));
    }
}

/* Key Logic: - Convert all 0s in the array to -1 to simplify the problem.
              - Now the task becomes finding the longest subarray with a cumulative sum of 0.
              - Use a HashMap to store the first occurrence of each cumulative sum.
              - If the same sum appears again, the subarray between those indices has equal number of 0s and 1s.
              - Update the maximum length whenever such a subarray is found. */
