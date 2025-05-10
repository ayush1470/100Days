/* LeetCode Problem: (3) Longest Substring Without Repeating Characters */

import java.util.*;

public class Day32Main{
    public static int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for(int right=0; right<s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

/* Key Logic: - Use a sliding window approach with two pointers (left and right).
              - Move the right pointer to expand the window and add unique characters to the HashSet.
              - If a duplicate character is found, move the left pointer forward and remove characters
                from the set until the duplicate is removed.
              - At each step, update maxLength with the size of the current window (right - left + 1).
              - This ensures we always track the longest substring without repeating characters. */