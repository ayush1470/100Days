/* LeetCode Problem: (457) Circular Array Loop */

public class Day48Main{
    public static boolean circularArrayLoop(int[] nums){
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0) continue; // already visited

            // slow and fast pointers
            int slow = i, fast = getNextIndex(nums, i);

            // check direction
            while(nums[slow] * nums[fast] > 0 && nums[slow] * nums[getNextIndex(nums, fast)] > 0){
                if(slow == fast){
                    // cycle found, check if it's not a one-element loop
                    if(slow == getNextIndex(nums, slow)) break;
                    return true;
                }
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }

            // mark all nodes in this sequence as 0 (visited)
            int val = nums[i];
            int j = i;
            while(nums[j] * val > 0){
                int next = getNextIndex(nums, j);
                nums[j] = 0; // mark as visited
                j = next;
            }
        }
        return false;
    }

    private static int getNextIndex(int[] nums, int i){
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n; // handle negative modulo
    }

    // Example usage
    public static void main(String[] args){
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(circularArrayLoop(new int[]{-1, -2, -3, -4, -5, 6}));
        System.out.println(circularArrayLoop(new int[]{1, -1, 5, 1, 4}));
    }
}

/* Key Logic: - The algorithm uses the Floyd's Cycle Detection (Tortoise and Hare) technique with
                slow and fast pointers to detect cycles.
              - A cycle is valid only if:
                - All elements in the cycle move in the same direction (either all positive or
                  all negative).
                - The cycle length is greater than 1 (i.e., not self-looping).
              - To achieve O(1) space, we modify the original array by marking visited indices with 0.
              - The getNextIndex() method wraps around the array correctly even for negative steps
                using modulo operations.
              - If a cycle is detected, return true.
              - If no valid cycle is found from the current index, mark the entire path as visited
                to avoid redundant checks. */

