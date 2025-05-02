/* LeetCode Problem: (557) Reverse Words in a String III */

public class Day24Main{
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;

        for (int end = 0; end <= n; end++) {
            // When we reach a space or the end of string, reverse the word
            if (end == n || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1; // Move start to the next word
            }
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}

/* Key Logic: 1. Convert the string to a char array for in-place modifications.
              2. Use two pointers (start and end) to find each word separated by spaces.
              3. For each word, reverse the characters between start and end-1.
              4. Move start to the next word after each space and repeat.
              5. Finally, return the modified char array as a new string. */