/* LeetCode Problem: (1385) Find the Distance Value Between Two Arrays */

public class Day29Main{
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d){
        int value = 0;
        for(int i=0; i<arr1.length; i++){
            boolean valid = true;
            for(int j=0; j<arr2.length; j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    valid = false;
                    break;
                }
            }
            if(valid){
                value++;
            }
        }
        return value;
    }

    public static void main(String[] args){
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        System.out.println(findTheDistanceValue(arr1,arr2,d));
    }
}

/* Key Logic: 1. Sort both arr1 and arr2.
              2. Use two pointers (i for arr1, j for arr2).
              3. For each arr1[i], move arr2's pointer j until arr2[j] is out of distance d.
              4. If both arr2[j] and arr2[j-1] are farther than d, count arr1[i] as valid.
              5. This avoids checking every pair and reduces time complexity. */