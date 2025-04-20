/* LeetCode Problem: (238) Product of Array Except Self */

import java.util.*;

public class Day12Main{
    public static int[] getProductExceptSelf(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        int[] left = new int[n];  /* Contains the product of all the numbers on the
                                     left side of that number except that number */
        int[] right = new int[n]; /* Contains the product of all the numbers on the
                                     right side of that number except that number */
        left[0] = 1;
        for(int i=1; i<n; i++){  // we start from 1 as we already defined 0 case above
            left[i] = left[i-1]*nums[i-1];
        }
        right[n-1] = 1;
        for(int i=n-2; i>=0; i--){  // same way we start from back of the array in reverse direction
            right[i] = right[i+1]*nums[i+1];
        }
        // To store the product of left and right in an Array -> that is our Answer
        for(int i=0; i<n; i++){ /* We are starting from 0 not 1 -> (for Why? Just see what
                                   the edge cases are going to look like (0 and n-1)) */
            answer[i] = left[i]*right[i];
        }
        return answer;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(getProductExceptSelf(nums)));
    }
}

/*
Key Logic:
         - We need to find the product of all elements except the current one, without using division.
         - For each index `i`, the result should be the product of all elements to the left of `i` and
           all elements to the right of `i`.
         - So, we build two helper arrays:
            1. `left[i]` holds the product of all elements before index `i`.
            2. `right[i]` holds the product of all elements after index `i`.
         - Finally, the answer for index `i` is: left[i] * right[i]
         - This approach avoids division and ensures O(n) time complexity.
*/
