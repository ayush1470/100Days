/* LeetCode Problem: (992): Subarrays with K Different Integers */

import java.util.*;

public class Day87Main{
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private static int atMostK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) {
                k--;
            }

            while (k < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }
}

/* Key Logic:
   - To count subarrays with exactly k distinct integers, we use:
       countExactlyK = countAtMostK(k) - countAtMostK(k - 1)
   - The helper method countAtMostK(k) counts subarrays with at most k distinct elements using a sliding
     window:
       - Expand the window with the right pointer, adding elements to a frequency map.
       - If the number of distinct elements exceeds k, shrink the window from the left until the
         condition is met.
       - For each position of right, the number of valid subarrays ending at right is (right - left + 1).
   - This avoids generating all subarrays explicitly and achieves O(n) time complexity. */
