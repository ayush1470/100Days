/* LeetCode Problem: (1234) Replace the Substring for Balanced String */

import java.util.HashMap;
import java.util.Map;

public class Day54Main{
    public static int balancedString(String s){
        int n = s.length();
        int required = n / 4;
        Map<Character, Integer> count = new HashMap<>();
        // Count frequency of each character
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // If already balanced
        if(isBalanced(count, required)){
            return 0;
        }

        int minLen = n;
        int left = 0;

        // Sliding window to find minimal substring to replace
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            count.put(c, count.get(c) - 1);

            // Check if current substring balances the rest
            while(left <= right && isBalanced(count, required)){
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) + 1);
                left++;
            }
        }
        return minLen;
    }

    // Check if all characters are <= required frequency
    private static boolean isBalanced(Map<Character, Integer> count, int required){
        return count.getOrDefault('Q', 0) <= required &&
                count.getOrDefault('W', 0) <= required &&
                count.getOrDefault('E', 0) <= required &&
                count.getOrDefault('R', 0) <= required;
    }

    public static void main(String[] args){
        System.out.println(balancedString("QWER"));
        System.out.println(balancedString("QQWE"));
        System.out.println(balancedString("QQQW"));
    }
}

/* Key Logic: - Calculate the frequency of each character ('Q', 'W', 'E', 'R') in the entire string.
              - Determine the target frequency for each character: n / 4.
              - If all characters already meet or are below the target frequency, the string is
                balanced (return 0).
              - Use a sliding window approach:
                 - Move the right pointer forward, decrementing the frequency of the current character
                   in the frequency map.
                 - Check if the remaining characters outside the window are balanced.
                 - If balanced, try shrinking the window from the left to find the minimum length
                   substring that contains all excess characters.
              - The minimal window size found during this process is the smallest substring that
                needs to be replaced.
              - Return this minimal length as the result. */
