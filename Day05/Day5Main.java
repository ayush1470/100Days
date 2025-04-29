/* LeetCode Problem: (228) Summary Ranges */

import java.util.*;

public class Day5Main{
    public static List<String> summaryRanges(int[] nums) {
        /* This is my first approach: (Why this was bad approach was because
           I was focusing on both a and b in range [a,b] while I should have
           just made a 'start pointer' and accordingly checked if numbers are
           continuous in sequence like(1,2,3 or 7,8,9) or there is no sequence
           present for that number).

        PREVIOUS CODE:
        int a = 0, b = 0;
        int count = 0;
        ArrayList<String>ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(count==0){
                a = nums[i];
            }
            if(i+1<nums.length && nums[i+1]==nums[i]+1){
                count++;
            }else{
                count=0;
                if(count==0){
                    b=nums[i];
                }if(a!=b){
                    ans.add(Integer.toString(a) + "->" + Integer.toString(b));
                }else{
                    ans.add(Integer.toString(a));
                }
            }
        }
        return ans; */

        // OPTIMISED CODE:
        int i = 0;
        int n = nums.length;
        ArrayList<String> ans = new ArrayList<>();
        while(i<n){
            int start = i; /* start pointer (Koi naya number hai toh
                              usse shuru karo dekhna ki sequence hai ki nhi) */
            while(i+1<n && nums[i+1]==nums[i]+1){
                /* i+1<n is used to avoid OutOfBound Exception (eg. if 'i' was the last element of array
                 and so because of the condition: nums[i+1] == ..... the i+1 part is going
                 to cause this exception as index 'i' goes outside the array */
                i++;
            }
            if(start==i){
                ans.add(Integer.toString(nums[start]));
            }else{
                ans.add(nums[start] + "->" + nums[i]);  /* No need to use Integer.toString as
                                                        when we are using it with "->" Java performs
                                                        string concatenation and automatically converts
                                                        integer to String. */
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}