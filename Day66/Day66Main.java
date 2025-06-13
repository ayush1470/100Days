/* LeetCode Problem: (922) Sort Array By Parity II */

public class Day66Main{
    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0; // Even index
        int j = 1; // Odd index
        int n = nums.length;
        while (i < n && j < n) {
            // If nums[i] is even, it's in the right place; move on
            if (nums[i] % 2 == 0) {
                i += 2;
            }
            // If nums[j] is odd, it's in the right place; move on
            else if (nums[j] % 2 == 1) {
                j += 2;
            }
            // nums[i] is odd and nums[j] is even -> swap
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] result = sortArrayByParityII(new int[]{4, 2, 5, 7});
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

/* Key Logic: - We use two pointers:
                  -> i: tracks even indices (0, 2, 4, ...)
                  -> j: tracks odd indices (1, 3, 5, ...)
              - Iterate while both i and j are within array bounds.
              - At each step:
                  - If nums[i] is even, it's correctly placed at an even index; move i ahead by 2.
                  - If nums[j] is odd, it's correctly placed at an odd index; move j ahead by 2.
                  - If nums[i] is odd and nums[j] is even, they are in the wrong positions:
                      -> Swap nums[i] and nums[j].
                       -> Then increment both i and j by 2.
              - This guarantees that even numbers end up at even indices and odd numbers at odd indices.
              - Since the array has equal even and odd numbers, this approach is valid and in-place. */
