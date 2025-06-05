/* LeetCode Problem: (80) Remove Duplicates from Sorted Array II */

public class Day58Main{
    public static int removeDuplicates(int[] nums){
        if (nums.length <= 2) {
            return nums.length;
        }
        // Two pointers: i for writing position, j for reading position
        int i = 2; // Start from index 2 since first two elements are always valid

        for (int j = 2; j < nums.length; j++) {
            // If current element is different from the element two positions back
            // in our result array, we can include it (allows at most 2 duplicates)
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = removeDuplicates(nums1);
        System.out.println("Test 1 - k: " + k1);
        System.out.print("Result: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
    }
}

/* Key Logic: - We use two pointers: 'i' for writing valid elements, 'j' for reading through array
              - Start from index 2 since first two elements are always valid (at most 2 duplicates allowed)
              - For each element at position 'j', compare it with element at position 'i-2'
              - If nums[j] != nums[i-2], we can safely include nums[j] because:
                - It means we don't have 2 consecutive duplicates of this value in our result yet
                - The array is sorted, so if current element differs from i-2 position,
                  it's either a new element or we have room for one more duplicate
              - If nums[j] == nums[i-2], skip it because we already have 2 occurrences
              - Time: O(n), Space: O(1) - single pass with constant extra space */