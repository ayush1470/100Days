/* LeetCode Problem: (523) Continuous Subarray Sum */

import java.util.*;

public class Day40Main{
    public static boolean checkSubarraySum(int[] nums, int k){
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1); // Important to handle the case where the prefix itself is divisible by k

        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int remainder = k == 0 ? sum : sum % k;

            if(remainderIndex.containsKey(remainder)){
                if(i - remainderIndex.get(remainder) >= 2){
                    return true;
                }
            }else{
                remainderIndex.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }
}


/* Key Logic: - We use the concept that if the sum of a subarray is divisible by k,
                then the remainders of the prefix sums at the start and end of that subarray must be equal.
              - So, we keep track of the earliest index where each remainder (sum % k) occurs
                using a HashMap.
              - If the same remainder appears again at a later index, and the subarray length
                is at least 2, then the subarray sum is divisible by k.
              - We initialize the map with (0, -1) to handle the case where the prefix sum
                itself is divisible by k.
              - This reduces time complexity from O(n²) to O(n). */
