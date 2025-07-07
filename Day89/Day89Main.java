/* LeetCode Problem: (162): Find Peak Element */

public class Day89Main{
    public static int findPeakElement(int[] nums){
        int start = 0, end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}

/* Key Logic:
We use a modified binary search to find a peak element.
A peak element is defined as an element strictly greater than its neighbors.
By comparing the middle element with its next one, we decide whether to move left or right.

- If nums[mid] > nums[mid + 1], then a peak must exist on the left side (including mid).
- If nums[mid] < nums[mid + 1], then a peak must exist on the right side (excluding mid).
- This works because at least one peak is guaranteed to exist.
- We continue narrowing the search until start == end, which is the peak index. */
