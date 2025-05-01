/* LeetCode Problem: (49) Group Anagrams */

import java.util.*;

public class Day23Main {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map to store sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert string to char array, sort it, and convert back to string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Add to map
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }

    // For testing
    public static void main(String[] args){
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
    }
}

/* Key Logic: - For each word in the array:
                 - Sort its characters to form a standardized key.
                 - All anagrams will have the same sorted key (e.g., "eat", "tea", "ate" => "aet").
                 - Use a HashMap to group words by this sorted key.
              - Finally, collect all grouped anagram lists from the map and return. */
