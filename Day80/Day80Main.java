/* LeetCode Problem: (852): Peak Index in a Mountain Array */

public class Day80Main{
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }else if(arr[mid] < arr[mid - 1]){
                end = mid;

            }else if (arr[mid] < arr[mid + 1]){
                start = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {0,1,2,1};
        System.out.println(peakIndexInMountainArray(arr));
    }
}

/* Key Logic: - Use binary search to find the peak index in a mountain array by comparing middle
                element with its neighbors.
              - If the 'mid' element is greater than both neighbors, it's the peak.
              - If it's smaller than the left neighbor, the peak lies to the left; otherwise,
                it lies to the right. */