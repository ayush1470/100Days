/* LeetCode Problem: (287) Find the Duplicate Number */

public class Day44Main{
    public static int findDuplicate(int[] nums){
        // Phase 1: Detect cycle using Floyd’s Tortoise and Hare
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];       // move one step
            fast = nums[nums[fast]]; // move two steps
        }while(slow != fast);

        // Phase 2: Find entrance to the cycle (duplicate number)
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}

/* Key Logic: - The array can be visualized as a linked list where each value in the array points
                to the next index.
                For example: index = i, value = nums[i], so nums[i] acts like a pointer to the next node.

              - Since values range from 1 to n and there are n+1 elements, at least one value must
                repeat (Pigeonhole Principle).
                This guarantees that the "linked list" formed by following the indices must contain
                a cycle.

              - Floyd’s Tortoise and Hare algorithm is used to detect the cycle:
                - Phase 1: Move 'slow' one step and 'fast' two steps until they meet inside the cycle.
                - Phase 2: Move one pointer to the start, and then move both one step at a time.
                  The point they meet again is the cycle start — the duplicate number.

              - This approach works in O(n) time and O(1) space, satisfying the problem constraints. */
