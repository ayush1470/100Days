/* LeetCode Problem: (974) Subarrays Sums Divisible by K */

import java.util.*;

public class Day46Main{
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);  // Initialize with 0 remainder seen once

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            int remainder = sum % k;

            // Handle negative remainders
            if (remainder < 0) {
                remainder += k;
            }

            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;
        System.out.println("Output: " + subarraysDivByK(nums1, k1)); // Output: 7

        int[] nums2 = {5};
        int k2 = 9;
        System.out.println("Output: " + subarraysDivByK(nums2, k2)); // Output: 0
    }
}

/* Key Logic: - We use a prefix sum approach to calculate the cumulative sum as we iterate through the array.
              - For each prefix sum, we compute `sum % k` to find the remainder when divided by k.
              - If the same remainder has appeared before, it means the subarray between those two indices has a sum divisible by k.
              - We use a HashMap to store the frequency of each remainder.
              - Initialize the map with remainder 0 set to 1 to handle cases where the prefix sum itself is divisible by k.
              - Handle negative remainders by converting them to positive using `(remainder + k) % k`.

              Why this works:
              - If two prefix sums have the same remainder when divided by k, the elements between them sum to a multiple of k.

              Time and Space Complexity:
              - Time: O(n) — one pass through the array.
              - Space: O(k) — to store frequency of remainders. */

