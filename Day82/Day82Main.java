/* LeetCode Problem: (2064): Minimized Maximum of Products Distributed to Any Store */

public class Day82Main{
    public static int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for (int q : quantities) {
            right = Math.max(right, q);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(n, quantities, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canDistribute(int n, int[] quantities, int maxProductsPerStore) {
        int requiredStores = 0;
        for (int q : quantities) {
            requiredStores += (q + maxProductsPerStore - 1) / maxProductsPerStore; // ceiling(q / max)
        }
        return requiredStores <= n;
    }

    public static void main(String[] args){
        int n = 6;
        int[] quantities = {11,6};
        System.out.println(minimizedMaximum(n,quantities));
    }
}


/* Key Logic:

 - The goal is to minimize the maximum number of products (x) assigned to any store.

 - Since a store can only take one product type, but any amount of that type, we need
   to divide each quantity[i] into groups such that no group exceeds x.

 - We use binary search on the value of x (from 1 to max(quantities)) to efficiently find
   the smallest possible valid x.

 - For a candidate x (mid), we calculate the total number of stores needed:
     - For quantities[i], number of stores needed = ceil(quantities[i] / x)
     - We use (quantities[i] + x - 1) / x to compute ceiling without floating point.

 - If the total required stores for current x is <= n, it's a valid solution.
     - Try smaller x to minimize further → move right = mid
 - Otherwise, try a larger x → move left = mid + 1

 - The minimal value of x that satisfies the store constraint is the answer.
*/
