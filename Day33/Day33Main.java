/* LeetCode Problem: (219) Contains Duplicate II */

import java.util.*;

public class Day33Main{
    public static boolean containsDuplicate(int[] nums, int k){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){  /* If the duplicate contains in the window (of size k)
                                           then all conditions satisfied so return true */
                return true;
            }
            set.add(nums[i]);  // If new element then we add it in the HashSet
            if(set.size() > k){  /* Instead of checking Math.abs(i-j), we are doing this as what
                                    i-j<=k means is that both i and j should lie in between 0 to k */
                set.remove(nums[i-k]);  /* this will remove the last element from the window ('i-k')
                                           as soon as the window size is larger than k */
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsDuplicate(nums, k));
    }
}

/* Key Logic: - Use a HashSet to keep track of elements within the current window of size at most k.
              - For each nums[i]:
                - If nums[i] is already in the set, we found a duplicate within distance k → return true.
                - Else, add nums[i] to the set.
              - If the set size exceeds k, remove nums[i - k] to maintain the window of last k elements.
              This ensures we only check for duplicates where abs(i - j) <= k. */