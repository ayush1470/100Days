/* LeetCode Problem: (1763) Longest Nice Substring */

public class Day55Main{
    public static String longestNiceSubstring(String s){
        int n = s.length();
        String res = "";

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n + 1; j++){
                String sub = s.substring(i, j);
                if(isNice(sub) && sub.length() > res.length()){
                    res = sub;
                }
            }
        }
        return res;
    }

    private static boolean isNice(String s){
        // Using sets to track characters
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for(char c : s.toCharArray()){
            if(Character.isLowerCase(c)){
                lower[c - 'a'] = true;
            }else{
                upper[c - 'A'] = true;
            }
        }
        for(int i = 0; i < 26; i++){
            if(lower[i] != upper[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
        System.out.println(longestNiceSubstring("Bb"));
        System.out.println(longestNiceSubstring("c"));
    }
}

/* Key Logic: - Iterate through all possible substrings of the input string.
              - For each substring, check if it is "nice":
                  - A string is "nice" if for every letter it contains, both its uppercase and
                    lowercase forms are present.
              - To check this, use two boolean arrays (one for lowercase, one for uppercase).
              - Mark the presence of each character accordingly.
              - If for any letter the lowercase and uppercase presence doesn't match, it's not nice.
              - Track the longest nice substring found.
              - Return the first longest nice substring if there are multiple with the same length. */
