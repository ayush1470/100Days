/* LeetCode Problem: (917) Reverse Only Letters */

public class Day28Main{
    public static String reverseOnlyLetters(String s){
        char[] str = s.toCharArray();
        int left = 0, right = str.length - 1;
        while(left <= right){
            if(Character.isLetter(str[left]) && Character.isLetter(str[right])){
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }else if(!Character.isLetter(str[left])){
                left++;
            }else{
                right--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args){
        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
    }
}

/* Key Logic: 1. Two Pointers: We maintain two pointers (`left` and `right`), starting from
                 the beginning and the end of the string, respectively.
              2. Character Swap: We check if both characters at `left` and `right` are
                 alphabetic letters. If they are, we swap them.
              3. Skip Non-Letters: If either `str[left]` or `str[right]` is not a letter
                 (i.e., not in the alphabet), we simply move the respective pointer to the next
                 valid position.
              4. Repeat: This process continues until the two pointers meet or cross each other.

              This ensures that only the letters are reversed in the string,
              while non-letter characters (such as punctuation, spaces, digits, etc.)
              remain in their original positions. */