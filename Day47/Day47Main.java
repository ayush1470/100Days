/* LeetCode Problem: (1177) Can Make Palindrome from Substring */

import java.util.*;

public class Day47Main{
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries){
        int n = s.length();
        int[][] prefixFreq = new int[n + 1][26];

        // Build prefix frequency array
        for(int i = 0; i < n; i++){
            System.arraycopy(prefixFreq[i], 0, prefixFreq[i + 1], 0, 26);
            prefixFreq[i + 1][s.charAt(i) - 'a']++;
        }

        List<Boolean> result = new ArrayList<>();

        for(int[] q : queries){
            int left = q[0], right = q[1], k = q[2];
            int oddCount = 0;
            // Count characters with odd frequencies in the substring
            for(int i = 0; i < 26; i++){
                int freq = prefixFreq[right + 1][i] - prefixFreq[left][i];
                if(freq % 2 != 0) oddCount++;
            }
            // We can fix up to 2*k odd counts (each replacement fixes 2)
            result.add(oddCount / 2 <= k);
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        System.out.println(canMakePaliQueries(s, queries)); // [true, false, false, true, true]
    }
}

/* Key Logic: - We preprocess the string `s` by building a prefix frequency array `prefixFreq`,
                where prefixFreq[i][c] tells how many times character 'c' appears in the
                prefix s[0..i-1].

              - For each query [left, right, k]:
                - We calculate the frequency of each character in the substring s[left..right]
                  using prefixFreq[right + 1][i] - prefixFreq[left][i].

                - Count how many characters in that substring have an odd frequency — because in
                  a palindrome, at most one character can have an odd count (if length is odd),
                  and all others must be even.

                - Each replacement can fix 2 odd characters (replace one with another),
                  so if `oddCount / 2 <= k`, we can make it a palindrome.

              - Return true if the substring can be rearranged and changed (using up to k changes) into a palindrome.
                Otherwise, return false. */
