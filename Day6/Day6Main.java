/* LeetCode Problem: (448) Find all the numbers disappeared in an Array */

import java.util.*;

public class Day6Main{
    public static ArrayList<Integer> findDisappearedNumbers(int[] nums) {
        // Mark visited numbers by negating the number at their corresponding index
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        // Collect indices which are still positive — those numbers were missing
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}