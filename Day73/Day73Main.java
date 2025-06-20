/* LeetCode Problem: (2016): Maximum Difference Between Increasing Elements */

public class Day73Main{
    public static int maximumDifference(int[] nums) {
        int minVal = nums[0];
        int maxDiff = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minVal) {
                maxDiff = Math.max(maxDiff, nums[i] - minVal);
            } else {
                minVal = nums[i];
            }
        }

        return maxDiff;
    }

    public static void main(String[] args){
        int[] nums = {7,1,5,4};
        System.out.println(maximumDifference(nums));
    }
}

/* Key Logic: - We maintain the minimum element seen so far while iterating through the array.
              - At each step, we check if the current number is greater than this minimum.
              - If it is, we calculate the difference and update the maximum difference found.
              - If not, we update the minimum value to the current number.
              - This guarantees j > i and ensures we find the maximum possible nums[j] - nums[i]. */



