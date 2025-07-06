/* LeetCode Problem: (1394): Find Lucky Integer in an Array */

public class Day88Main{
    public static int findLucky(int[] arr) {
        int[] freq = new int[501];
        int max = -1;
        for(int i=0; i<arr.length; i++){
            if(i == 0){
                freq[i] = -1;
            }
            freq[arr[i]]++;
        }
        for(int i=0; i<freq.length; i++){
            if(freq[i] == i){
                max = Math.max(i, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
}

/* Key Logic:
   - A "lucky" integer is one whose frequency in the array equals its value.
   - We use a frequency array of size 501 (since the problem constraint is 1 <= arr[i] <= 500).
   - First loop: Count occurrences of each number in the input array.
   - Second loop: Check which numbers have a frequency equal to their own value (i.e., lucky numbers).
       - Track the maximum among such lucky numbers.
   - If no lucky number is found, return -1. */


