/* LeetCode Problem: (718) Maximum Length of Repeated Subarray */

public class Day56Main{
    public static int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;

        // Case 1: Slide nums1 over nums2 (nums1 starts from different positions)
        for (int offset = 0; offset < nums1.length; offset++) {
            maxLength = Math.max(maxLength, findMaxLengthAtOffset(nums1, nums2, offset, 0));
        }

        // Case 2: Slide nums2 over nums1 (nums2 starts from different positions)
        for (int offset = 1; offset < nums2.length; offset++) {
            maxLength = Math.max(maxLength, findMaxLengthAtOffset(nums1, nums2, 0, offset));
        }

        return maxLength;
    }

    // Find maximum common subarray length when arrays are aligned at given offsets
    private static int findMaxLengthAtOffset(int[] nums1, int[] nums2, int offset1, int offset2) {
        int maxLength = 0;
        int currentLength = 0;

        // Compare elements while both arrays have valid indices
        int i = offset1, j = offset2;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // Extend current window
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Reset window
                currentLength = 0;
            }
            i++;
            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println("Test 1: " + findLength(nums1, nums2));

        int[] nums3 = {0, 0, 0, 0, 0};
        int[] nums4 = {0, 0, 0, 0, 0};
        System.out.println("Test 2: " + findLength(nums3, nums4));
    }
}

/* Key Logic: - Use sliding window technique by aligning arrays at different offsets
              - Try all possible alignments: nums1 shifted over nums2, and nums2 shifted over nums1
              - For each alignment, find longest consecutive matching sequence
              - Avoids checking all subarray pairs by using systematic offset-based approach */