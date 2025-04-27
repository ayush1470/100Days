/* LeetCode Problem: (345) Reverse Vowels of a String */

import java.util.*;

public class Day19Main{
    public static String reverseVowels(String s){
        Set<Character> vowels = new HashSet<>(Arrays.asList(  // Learn the syntax of HashSet
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] str = s.toCharArray();
        int left = 0, right = s.length()-1;
        while(left < right){
            if(vowels.contains(str[left]) && vowels.contains(str[right])){
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }else if(!vowels.contains(str[left])){
                left++;
            }else if(!vowels.contains(str[right])){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args){
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }
}

/* Key Logic: - We use two pointers: `left` starting at the beginning of the string,
                and `right` starting at the end.
              - The goal is to swap vowels between the two pointers and move them towards the center.
              - If both `left` and `right` point to vowels, we swap them.
              - If `left` is not a vowel, we move the `left` pointer forward.
              - If `right` is not a vowel, we move the `right` pointer backward.
              - The process continues until the two pointers cross each other.
              - This ensures that only vowels are swapped, and all other characters remain
                in their original position. */