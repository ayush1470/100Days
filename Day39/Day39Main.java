/* LeetCode Problem: (303) Range Sum Query - Immutable */

public class Day39Main{
    private int[] prefixSum;

    public Day39Main(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Day39Main numArray = new Day39Main(nums);

        System.out.println(numArray.sumRange(0, 2)); // Output: 1
        System.out.println(numArray.sumRange(2, 5)); // Output: -1
        System.out.println(numArray.sumRange(0, 5)); // Output: -3
    }
}

/* Key Logic: - We use a prefix sum array to store the cumulative sum of elements up to each index.
              - This allows us to compute the sum of any subarray in constant time using:
                sumRange(left, right) = prefixSum[right + 1] - prefixSum[left]
              - This improves performance for multiple queries compared to recalculating the sum each
                time. */
