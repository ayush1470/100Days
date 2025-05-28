/* LeetCode Problem: (647) Palindromic Substrings */

public class Day50Main{
    public static int countSubstrings(String s){
        int count = 0;
        int n = s.length();
        // There are 2n - 1 centers (each character and between characters)
        for(int center = 0; center < 2 * n - 1; center++){
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc")); // Output: 3
        System.out.println(countSubstrings("aaa")); // Output: 6
    }
}

/* Key Logic: - Each palindromic substring has a "center" — either a single character or a pair
                of characters.
              - There are 2n - 1 possible centers in a string of length n:
                  - n centers at each character (odd-length palindromes)
                  - n - 1 centers between characters (even-length palindromes)
              - For each center, expand outward while the characters on both sides are equal.
              - Each time a valid palindrome is found during expansion, increment the count.
              - This method avoids recomputation and gives an efficient O(n^2) time complexity. */
