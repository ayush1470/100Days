/* LeetCode Problem: (344) Reverse String */

import java.util.*;

public class Day18Main {
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right){  // only swap until left is 'strictly' less than right
            /* For odd numbered arrays the left==right element is going to be middle
               element which we don't require to change */
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}

/* Key Logic: Use two pointers (left and right) to swap characters from start and end,
              moving towards the center until all characters are reversed. */