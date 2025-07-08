/* LeetCode Problem: (416): Partition Equal Subset Sum */

import java.util.Arrays;

class Day90Main{
    public static boolean canPartition(int[] nums) {
        // 1. Compute total sum
        int total = Arrays.stream(nums).sum();
        if ((total & 1) == 1) return false;  // odd sum ⇒ impossible

        int target = total / 2;  // subset‑sum target

        // 2. DP array: dp[s] == true <-> a subset with sum s is reachable
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;   // base case: sum 0 is always achievable

        // 3. For each number, update reachable sums (right‑to‑left to avoid re‑use)
        for (int num : nums) {
            for (int s = target; s >= num; --s) {
                dp[s] |= dp[s - num];
            }
            if (dp[target]) return true;  // early exit if target reached
        }

        // 4. Answer: can we hit exactly target?
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}

/* Key Logic:
The problem asks whether the array can be partitioned into two subsets with equal sum.
If the total sum is odd, such a partition is impossible.
Otherwise, we reduce the problem to checking whether a subset exists with sum = totalSum / 2.

- We use dynamic programming to track all achievable subset sums.
- Define a boolean array dp[] where dp[s] is true if a subset sum of s is possible.
- Start with dp[0] = true since a sum of 0 is always possible (empty subset).
- For each number, update dp[] from right to left to avoid using the same number multiple times.
- If dp[target] becomes true (target = totalSum / 2), return true.

This ensures all combinations are considered without recomputation.

Time Complexity: O(n × target)
Space Complexity: O(target)
*/
