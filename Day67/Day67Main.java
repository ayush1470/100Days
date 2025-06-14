/* LeetCode Problem: (187) Repeated DNA Sequences */

import java.util.*;

public class Day67Main{
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        // Only process if the string is at least 10 characters long
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        String input1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(input1));
    }
}

/* Key Logic: - We use a sliding window approach to iterate through all possible 10-letter
                substrings of the input DNA sequence.
              - A HashSet called 'seen' keeps track of all substrings we've encountered so far.
              - A second HashSet called 'repeated' stores only those substrings that appear more
                than once.
              - If a substring is already in 'seen', we add it to 'repeated'. Otherwise, we add
                it to 'seen'.
              - Finally, we return the list of repeated sequences by converting the 'repeated'
                set into a list. */