/* LeetCode Problem: (658): Find K Closest Elements */

import java.util.*;

public class Day86Main{
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = (left + right) / 2;

            // Compare the distances from x to decide the better window
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Collect the k closest elements starting from left
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3)); // Output: [1,2,3,4]
    }
}

/* Key Logic:
   - Since the array is sorted, the k closest elements to x must form a contiguous subarray.
   - Use binary search to find the left boundary (starting index) of the subarray of size k.
   - At each step, compare the distance of x from arr[mid] and arr[mid + k]:
     - If x is closer to arr[mid + k], move the left bound to mid + 1.
     - Else, move the right bound to mid.
   - This ensures we zero in on the window where the elements are closest to x.
   - Finally, return the subarray starting from the found left index of length k. */
