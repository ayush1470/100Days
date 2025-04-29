public class Day1Main {
    public static int minOperations(int[] nums, int k){
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){  // To find the largest number in array 'nums'
            maxi = Math.max(maxi, nums[i]);
        }
        int[] Count = new int[maxi +1];  // Created a frequency array of length maxi + 1
        for(int i=0; i<nums.length; i++){
            if(nums[i]<k){  /* if any element of nums is less than k then
                               it is impossible to make all elements of nums equal to k */
                return -1;
            }
            if(nums[i]>k){   /* just increment the value in the index value = nums[i]
                                of Count array */
                Count[nums[i]]++;
            }
        }
        int ans=0;
        for(int i=0; i<Count.length; i++){ /* This just returns the number of values in Count
                                              array th at are greater than 0, which gives us the answer. */
            if(Count[i]>0){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,5,4,5};
        int k = 2;
        System.out.println(minOperations(nums,k));
    }
}

/* Logic: The Count array is just a frequency array that consists of all the elements of the nums array as
          indices of Count array, and we are calculating the frequency of each element coming in the nums
          array.
          The basic logic behind this, is that we need to make minimum two changes in order to make
          whole array from {5,2,5,4,5} to {2,2,2,2,2} by replacing all 5's by 2 and 4 by 2.
          So the Count array just tells us which numbers are present apart from k (which was 2 here)
          which are greater than k and so only those numbers are going to be replaced by k (here 2). */