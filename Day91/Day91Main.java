/* LeetCode Problem: (633): Sum of Square Numbers */

public class Day91Main{
    public static boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        long sum = 0;
        while(left <= right){
            sum = (long) left*left + (long) right*right;
            if(sum == c){
                return true;
            }
            else if(sum < c){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 5;
        System.out.println(judgeSquareSum(c));
    }
}

/* Key Logic:

    The goal is to determine whether a number `c` can be expressed as
    the sum of squares of two non-negative integers: a² + b² = c.

    1. Use a two-pointer approach:
       - Initialize `left` at 0 (smallest possible value for a).
       - Initialize `right` at sqrt(c) (largest possible value for b such that b² ≤ c).

    2. While left ≤ right:
       - Compute the sum: left² + right².
       - If the sum equals c, return true.
       - If the sum is less than c, increment `left` to increase the sum.
       - If the sum is greater than c, decrement `right` to decrease the sum.

    3. If the loop ends without finding a match, return false.

    Notes:
    - Use `long` during square calculation to avoid integer overflow.
    - Time complexity is O(sqrt(c)) since `right` starts from sqrt(c) and both pointers move toward each other. */
