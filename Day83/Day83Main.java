/* LeetCode Problem: (594): Longest Harmonious Subsequence */

import java.util.HashMap;

public class Day83Main{
    public static int findLHS(int[] nums){
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        int maxLength = 0;
        for(int key : freq.keySet()){
            if(freq.containsKey(key + 1)){
                maxLength = Math.max(freq.get(key) + freq.get(key + 1), maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
}

/* Key Logic:
- Build a frequency map of all numbers in the array.
- A harmonious subsequence requires that the difference between the maximum and minimum value is exactly 1.
- For each unique key in the frequency map, check if (key + 1) exists.
  - If it does, then nums that are equal to key and key+1 can form a harmonious subsequence.
  - Compute the combined length: freq.get(key) + freq.get(key + 1).
  - Track the maximum of all such valid pairs.
- Return the maximum length found. */
