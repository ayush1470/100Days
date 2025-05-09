/* LeetCode Problem: (42) Trapping Rain Water */

public class Day31Main{
    public static int trap(int[] height){
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}

/* Key Logic: - For each position, the water trapped depends on the minimum of the highest
                bar on the left and the highest bar on the right.
              - So, for every index 'i':
                  water trapped at i = min(max bar on left, max bar on right) - height at i
              - We precompute:
                   1. leftMax[]: maximum height to the left (including current index)
                   2. rightMax[]: maximum height to the right (including current index)
              - Then, sum up trapped water at each index using the formula above. */


