/* LeetCode Problem: (167) Two Sum II - Input Array is Sorted */

import java.util.*;

public class Day27Main{
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int index = 0;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                numbers[index++] = left + 1;
                numbers[index++] = right + 1;
                break;
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return Arrays.copyOf(numbers,index);
    }

    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}

/* Key Logic: - Use two pointers: 'left' starting at 0 and 'right' starting at numbers.length - 1.
              - While left < right:
                  - If sum == target ➔ return the 1-based indices.
                  - If sum > target ➔ move 'right' pointer left (to reduce sum).
                  - If sum < target ➔ move 'left' pointer right (to increase sum).
              - This works because the array is sorted (two-pointer technique).
              - Uses O(1) extra space and O(n) time. */