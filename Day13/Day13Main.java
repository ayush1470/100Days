/* LeetCode Problem: (645) Set Mismatch */

import java.util.*;

public class Day13Main{
    public static int[] findErrorNums(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int duplicate = -1;
        int n = nums.length;
        int actualSum = 0;

        for (int num : nums) {
            if (seen.contains(num)) {
                duplicate = num;
            } else {
                seen.add(num);
                actualSum += num;
            }
        }

        int expectedSum = n * (n + 1) / 2;
        int missing = expectedSum - actualSum;

        return new int[]{duplicate, missing};
    }

    // Test it
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}

/* Key Logic: We use a HashSet to detect the duplicate number while calculating the
              sum of unique elements.
              The expected sum of 1 to n is calculated using the formula n*(n+1)/2.
              The missing number is the difference between the expected sum and the
              actual sum (excluding duplicate). */
