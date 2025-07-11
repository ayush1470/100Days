/* LeetCode Problem: (724): Find Pivot Index */

public class Day93Main{
    public static int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            prefix[i] = sum;
        }
        int leftSum = 0, rightSum = 0;
        for(int i=0; i<prefix.length; i++){
            rightSum = sum - prefix[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}