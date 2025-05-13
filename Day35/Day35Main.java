/* LeetCode Problem: (643) Maximum Average Subarray I */

public class Day35Main{
    public static double findMaxAverage(int[] nums, int k){
        // Step 1: Calculate the sum of the first window of size k
        double sum = 0;
        for (int i = 0; i < k; i++){
            sum += nums[i];
        }

        // Step 2: Initialize maxSum with the first window's sum
        double maxSum = sum;

        // Step 3: Slide the window through the array
        for (int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i - k]; // add next element and remove first element of previous window
            maxSum = Math.max(maxSum, sum);
        }

        // Step 4: Return the maximum average
        return maxSum / k;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.printf("Output: %.5f%n", findMaxAverage(nums1, k1));

        int[] nums2 = {5};
        int k2 = 1;
        System.out.printf("Output: %.5f%n", findMaxAverage(nums2, k2));
    }
}

/* Key Logic: 1. Use a sliding window of size k to calculate the sum of the first k elements.
              2. Initialize maxSum with this initial sum.
              3. Slide the window across the array:
                  - At each step, subtract the element that goes out of the window (nums[i - k]) and
                    add the new element that comes into the window (nums[i]).
                  - Update maxSum if the current window sum is greater.
              4. After traversing the array, return maxSum divided by k to get the maximum average. */

