/* LeetCode Problem: (704): Binary Search */

public class Day71Main{
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}

/* Key logic: - This code performs a binary search on a sorted integer array to find the index
                of a target element.
              - It repeatedly divides the search interval in half, narrowing down the possible
                positions of the target.
              - If the target is found, it returns its index. Otherwise, it returns -1. */
