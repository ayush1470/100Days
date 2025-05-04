/* LeetCode Problem: (680) Valid Palindrome II */

public class Day26Main{
    public static boolean validPalindrome(String s){
        int left = 0, right = s.length() - 1;

        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                // Try skipping either left or right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    // Helper function to check palindrome between indices
    private static boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "abcdecba";
        System.out.println(validPalindrome(s));
    }
}

/* Key Logic: - Use two pointers (`left` and `right`) starting from the ends of the string.
              - Move the pointers inward as long as characters match.
              - If a mismatch is found:
                  - Try skipping the left character OR the right character.
                  - Check if either resulting substring is a palindrome.
              - Only one deletion is allowed, so we check both options at the first mismatch. */
