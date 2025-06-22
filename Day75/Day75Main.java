/* LeetCode Problem: (2138): Divide a String Into Groups of Size k */

import java.util.Arrays;

public class Day75Main{
    public static String[] divideString(String s, int k, char fill){
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() % k != 0){
            sb.append(fill);
        }

        String[] arr = new String[(sb.length()/k)];
        for(int i=0; i<sb.length()/k; i++){
            arr[i] = sb.substring(i*k, (i+1)*k);
        }
        return arr;
    }

    public static void main(String[] args){
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        System.out.println(Arrays.toString(divideString(s, k, fill)));
    }
}

/* Key Logic:
1. Convert the input string to a StringBuilder for easier appending.
2. Pad the string with the `fill` character until its length becomes a multiple of `k`.
3. Calculate how many groups of size `k` will exist after padding.
4. Use a loop to extract substrings of length `k` and store them in the result array.
5. Return the resulting array of string groups.

This approach ensures:
- All substrings are of exact length `k`.
- Any leftover characters at the end are filled appropriately. */