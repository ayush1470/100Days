/* LeetCode Problem: (3201): Find the Maximum Length of Valid Subsequence I */

public class Day95Main{
    public static int maximumLength(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        int alternateCount = 0;
        int parity = -1;

        for (int i : nums) {
            if (i % 2 == 0) {
                evenCount++;
                if (parity == 1 || parity == -1) {
                    alternateCount++;
                }
            } else {
                oddCount++;
                if (parity == 0 || parity == -1) {
                    alternateCount++;
                }
            }

            parity = i % 2;
        }

        return Math.max(alternateCount, Math.max(evenCount, oddCount));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(maximumLength(nums));
    }
}