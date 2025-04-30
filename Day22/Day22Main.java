/* LeetCode Problem: (1089) Duplicate Zeros */

import java.util.*;

public class Day22Main{
    public static void DuplicateZeros(int[] arr){
        int zeros = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){  // Firstly find how many zeros are present in Array
            if(arr[i] == 0){
                zeros++;
            }
        }

        /* Now we will just start from back of array and
           duplicate zeros if zero is found in array as element. */
        int i = n - 1;
        int j = n - 1 + zeros;
        while(i < j){
            if(j < n){
                arr[j] = arr[i];
            }
            if(arr[i] == 0){
                j--;
                if(j < n){
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,0,2,3,0,4,5,0};
        DuplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}

/* Key Logic: 1. Count total zeros to know how much shift is needed.
              2. Use two pointers (i and j):
                  - i starts from end of original array
                  - j starts from end of "virtual" extended array (original length + zeros)
              3. Move from back to front:
                  - Copy elements if within bounds (j < arr.length)
                  - If element is zero, write zero twice (duplicate) and adjust j
              4. This shifting from back prevents overwriting unprocessed elements.
              5. Done fully in-place with O(1) extra space. */