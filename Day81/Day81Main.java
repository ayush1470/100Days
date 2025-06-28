/* LeetCode Problem: (540): Single Element in a Sorted Array */

public class Day81Main{
    public static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Ensure mid is even so pairs line up correctly
            if (mid % 2 == 1) {
                mid--; // shift left to make mid even
            }

            // If pair matches, single is after mid
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }

        // start == end -> single element
        return nums[start];
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}

/* Key Logic:
- Every element appears in pairs, and the single element breaks the pattern.
- In the correct pairing, the first occurrence of a pair is at an even index,
  and the second is at the next (odd) index.
- Use binary search to find the first index where the pattern breaks:
  - If nums[mid] == nums[mid + 1], the single element must be on the right.
  - If not, it's on the left (or at mid).
- Always make mid even to compare with mid + 1.
- Loop continues until start == end, which is the index of the single element.
- Time Complexity: O(log n), Space Complexity: O(1) */
