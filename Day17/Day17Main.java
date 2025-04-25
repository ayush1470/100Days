/* LeetCode Problem: (747) Largest Number At Least Twice of Others */

public class Day17Main{
    public static int dominantIndex(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int index_maxi = 0;
        // Find the max element and its index
        for(int i=0; i<nums.length; i++){
            if(nums[i]>maxi){
                maxi = nums[i];
                index_maxi = i;
            }
        }
        // Check if the max is at least twice every other element
        for (int i = 0; i < nums.length; i++) {
            if (i != index_maxi && maxi < 2 * nums[i]) {
                return -1;
            }
        }
        return index_maxi;
    }

    public static void main(String[] args){
        int[] nums = {3, 6, 1, 0};
        System.out.println(dominantIndex(nums));
    }
}

/* Key Logic: 1. Find the maximum element and its index in the array.
              2. Check if this maximum element is at least twice as large as every other element.
              3. If the condition holds for all elements, return the index of the maximum element.
              4. Otherwise, return -1. */