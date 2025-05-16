/* LeetCode Problem: (560) Subarray Sum Equals K */

import java.util.*;

public class Day38Main{
    public static int subarraySum(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to handle the case when prefix sum == k
        int sum = 0, count = 0;
        for (int num : nums){
            sum += num;
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] main){
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}


/* Key Logic: - We use prefix sums to calculate the sum of subarrays efficiently.
              - prefix[i] stores the sum of elements from index 0 to i.
              - A subarray from index i to j has a sum: prefix[j] - prefix[i-1] (for i > 0).
              - We check all such subarrays and count those whose sum equals k.
              - Additionally, we check prefix sums directly from index 0 to j in case the subarray
                starts at 0. */
