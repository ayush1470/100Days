/* LeetCode Problem: (713) Subarray Product Less Than k */

public class Day34Main{
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int product = 1;
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args){
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}

/* Key Logic: - Use sliding window with two pointers (left and right).
              - Multiply nums[right] to the current product.
              - If product >= k, shrink the window by dividing nums[left] and moving left forward.
              - For each right, count the valid subarrays ending at right as (right - left + 1).
              - This works because every subarray from left to right will have a product less than k. */
