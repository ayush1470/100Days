/* LeetCode Problem: (229) Majority Element II */

import java.util.*;

public class Day65Main{
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        // There can be at most 2 elements that appear more than n/3 times
        int candidate1 = 0, candidate2 = 1; // initialize to different values
        int count1 = 0, count2 = 0;

        // First pass: find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify the counts
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{1}));
        System.out.println(majorityElement(new int[]{1, 2}));
    }
}

/* Key Logic: - This solution uses an extended Boyer-Moore Voting Algorithm to find all elements
                that appear more than ⌊n/3⌋ times.
              - At most, there can be only two such elements in any array.
              - First pass:
                - Iterate through the array and maintain up to two potential candidates along with
                  their counts.
                - If the current element matches a candidate, increment its count.
                - If a candidate’s count drops to zero, replace it with the current element.
                - Otherwise, decrement both counts.
              - Second pass:
                - Verify actual frequencies of both candidates to confirm if they appear more than
                  n/3 times.
                - This approach ensures linear time complexity O(n) and constant space O(1),
                  satisfying the follow-up requirement. */
