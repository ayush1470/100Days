/* LeetCode Problem: (496) Next Greater Element I */

public class Day10Main {
    public static void nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = -1;
            // Find the index of nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                    break;
                }
            }

            // Search for next greater element after index
            int nextGreater = -1;
            for (int k = index + 1; k < nums2.length; k++) {
                if (nums2[k] > nums1[i]) {
                    nextGreater = nums2[k];
                    break;
                }
            }

            ans[i] = nextGreater;
        }
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }
}

/* Key Logic: For each element in nums1, find its position in nums2,
              and then search for the first greater element to its right in nums2.
              If found, that value is stored in the answer array; otherwise, store -1. */