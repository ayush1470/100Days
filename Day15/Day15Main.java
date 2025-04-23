/* LeetCode Problem: (1399) Count Largest Group */

import java.util.*;

public class Day15Main{
    // Made public as requested
    public static int getDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);  // calling public method
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            maxCount = Math.max(maxCount, map.get(sum));
        }

        int largerGroups = 0;
        for (int val : map.values()) {
            if (val == maxCount) {
                largerGroups++;
            }
        }

        return largerGroups;
    }

    public static void main(String[] args){
        int n = 13;
        System.out.println(countLargestGroup(n));
    }
}

/* Key Logic: For each number from 1 to n, calculate the sum of its digits.
              Group numbers based on their digit sum using a HashMap.
              We are populating the map and each index number in the map
              represents all the numbers have their digit sum equal to that index number.
              Track the size of the largest group while populating the map.
              Finally, count how many groups have that largest size and return the count. */
