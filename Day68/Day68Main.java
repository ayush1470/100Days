/* LeetCode Problem: (1297): Maximum Number of Occurrences of a Substring */

import java.util.*;

public class Day68Main{
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> countMap = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);

            if (countUniqueLetters(sub) <= maxLetters) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
                maxCount = Math.max(maxCount, countMap.get(sub));
            }
        }

        return maxCount;
    }

    private static int countUniqueLetters(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab", 2, 3, 4));
        System.out.println(maxFreq("aaaa", 1, 3, 3));
    }
}

/* Key Logic: - We want to find the maximum frequency of substrings in `s` that:
                   - Have a length between minSize and maxSize.
                   - Contain at most `maxLetters` unique characters.

              - To optimize performance, we only check substrings of length `minSize` because:
                   - Longer substrings appear less frequently, so they're less likely to give a
                     higher count.
                   - Checking all sizes from minSize to maxSize is computationally expensive.

              - We slide a window of size `minSize` over the string and:
                   - Use a HashMap to count frequency of valid substrings.
                   - Use a Set to count unique characters in the current substring.

              - We update the maximum frequency while iterating. */
