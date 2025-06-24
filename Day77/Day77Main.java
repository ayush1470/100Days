/* LeetCode Problem: (395): Longest Substring With At least K Repeating Characters */

public class Day77Main{
    public static int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private static int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;  // too short to be valid

        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int mid = start; mid < end; mid++) {
            if (freq[s.charAt(mid) - 'a'] < k) {
                int midNext = mid + 1;
                // Skip over all chars that are also invalid
                while (midNext < end && freq[s.charAt(midNext) - 'a'] < k) {
                    midNext++;
                }
                // Divide around the invalid char
                return Math.max(helper(s, start, mid, k), helper(s, midNext, end, k));
            }
        }
        return end - start;  // whole substring is valid
    }

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }
}

/* Key Logic: - Uses divide and conquer to solve the problem recursively.
              - Counts character frequencies in the current substring [start, end).
              - If all characters occur at least k times, the entire substring is valid.
              - If any character occurs fewer than k times, it becomes a split point.
              - Recursively checks the left and right parts split by that invalid character.
              - Returns the maximum length among valid substrings. */

