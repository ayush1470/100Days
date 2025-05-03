/* LeetCode Problem: (905) Sort Array by Parity */

import java.util.*;

public class Day25Main{
    public static int[] sortArraybyParity(int[] nums){
        int left = 0, right = nums.length-1;
        while(left < right){
            if(nums[left] % 2 > nums[right] % 2){
                // then we Swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }if(nums[left] % 2 == 0){
                left++;
            }if(nums[right] % 2 == 1){
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {3,1,2,4};
        System.out.println(Arrays.toString(sortArraybyParity(nums)));
    }
}

/* Key logic: - Use two pointers (left and right) to fill a new array.
              - Place even numbers at the start (left pointer) and odd numbers at the end (right pointer).
              - Increment left when placing even, decrement right when placing odd.
              - This ensures all even numbers come first, followed by odd numbers. */