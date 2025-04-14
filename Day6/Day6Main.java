/* LeetCode Problem: (448) Find All Numbers Disappeared in an Array */

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
        for (int i = 0; i < nums.length; i++) { /* After marking, any position that still has a
                                                positive number means you didn’t see that number.
                                                So, you add i + 1 (since positions start from 0)
                                                to the result.*/
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

/* Logic: Think of the list as a checklist where every position represents a number.
          When you find a number (say 3), go to the 3rd position in the list and put
          a minus sign there. That means: “Hey! I’ve seen number 3!”

          We use Math.abs() just in case that position was already marked earlier.
          [Because earlier in the loop, we might have made nums[i] negative
          (to mark it as seen). If we just used nums[i], we might get a wrong index
          (like -3 - 1 = -4, which is invalid).]

          So we do Math.abs(nums[i]) to make sure we're always using the original
          value — even if it’s negative now.)
          We're not adding any new list — we just mark the original list by
          changing the sign. */