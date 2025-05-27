/* LeetCode Problem: (1248) Count Number of Nice Subarrays */

import java.util.*;

public class Day49Main{
    public static int numberOfSubarrays(int[] nums, int k){
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);  // Base case: 0 odd numbers seen so far
        int oddCount = 0;
        int result = 0;
        for(int num : nums){
            // Count the odd numbers
            if(num % 2 == 1){
                oddCount++;
            }
            // Check if there's a subarray with exactly k odd numbers
            result += countMap.getOrDefault(oddCount - k, 0);

            // Update the map with current oddCount
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }
}


/* Key Logic: - Use a prefix sum approach where we count the number of odd numbers seen so far.
              - Maintain a HashMap (countMap) that stores how many times a particular count of
                odd numbers has occurred.
              - For each element in the array:
                  - If it’s odd, increment the odd count.
                  - Check how many times (oddCount - k) has occurred so far — this gives the number
                    of subarrays ending at the current index with exactly k odd numbers.
                  - Add that value to the result.
                  - Update the HashMap with the current oddCount.
              - This ensures we count all "nice" subarrays in O(n) time using prefix sum and hashmap. */

