/* LeetCode Problem: (3202): Find the Maximum Length of Valid Subsequence II */

public class Day97Main{
    public static int longestEqualSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 1;

        // For each possible remainder value (0 to k-1)
        for (int targetRemainder = 0; targetRemainder < k; targetRemainder++) {
            // dp[i] = longest valid subsequence ending at position with nums[i] % k
            int[] dp = new int[k];

            for (int i = 0; i < n; i++) {
                int currentMod = nums[i] % k;
                int newLength = 1;

                // To extend a subsequence, we need the previous element's mod
                // such that (prevMod + currentMod) % k == targetRemainder
                // So prevMod = (targetRemainder - currentMod + k) % k
                int requiredPrevMod = (targetRemainder - currentMod + k) % k;

                if (dp[requiredPrevMod] > 0) {
                    newLength = dp[requiredPrevMod] + 1;
                }

                // Update dp for current mod with the maximum length
                dp[currentMod] = Math.max(dp[currentMod], newLength);
                maxLength = Math.max(maxLength, newLength);
            }
        }

        return maxLength;
    }

    // Test method
    public static void main(String[] args) {
        // Test with provided examples
        int[] nums1 = {1,2,3,4,5};
        int k1 = 2;
        System.out.println("Example 1: " + longestEqualSubarray(nums1, k1)); // Expected: 5

        int[] nums2 = {1,4,2,3,1,4};
        int k2 = 3;
        System.out.println("Example 2: " + longestEqualSubarray(nums2, k2)); // Expected: 4

        // Test with TLE array
        int[] tleArray = {53536,43542,83138,55755,96254,1840,80993,16058,55443,51018,96973,79684,4154,29990,68472,28912,55314,1531,4805,51360,42449,33278,72728,20388,95360,91953,7408,67401,50757,78600,67116,12402,38781,85419,40275,87924,73991,86333,15439,14765,88347,94675,96346,80174,94144,62972,9140,39204,38538,74740,91268,72242,28908,69802,32027,57057,39376,48636,53368,39881,98964,84277,90368,38739,59366,74623,22508,97951,94460,20269,41054,64277,67014,61987,63895,43347,24041,20016,16806,51492,56869,54327,98080,37438,80501,15129,47926,81901,87675,59746,63809,66572,28995,57293,35997,75504,81696,42153,36994,28263};

        // Test with different k values
        for (int k = 2; k <= 10; k++) {
            long start = System.currentTimeMillis();
            int result = longestEqualSubarray(tleArray, k);
            long end = System.currentTimeMillis();
            System.out.println("k=" + k + ": " + result + " (took " + (end - start) + "ms)");
        }
    }
}