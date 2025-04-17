public class Day9Main{
    public static int findMaxConsecutiveOnes(int[] nums){
        int L = 0; // Left Pointer of our Sliding Window
        int R = 0; // Right Pointer of our Sliding Window
        int maxOnes = 0;
        while(R < nums.length){
            if(nums[R]==1){
                maxOnes = Math.max(maxOnes, R-L+1);  // key logic is: R-L+1
                R++;
            }else{
                L = R+1;
                R = L;
            }
        }
        return maxOnes;
    }

    public static void main(String[] args){
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}

/* Key Logic: Use two pointers (L and R) to create a sliding window that keeps track of consecutive 1s:
              Start both L and R at the beginning of the array.
              Expand the window (R++) as long as nums[R] == 1.
              Update maxOnes with the current window size: R - L + 1.
              Reset the window when a 0 is found by moving both L and R to R + 1.
              This ensures that you're always measuring the length of the current streak
              of consecutive 1s. */