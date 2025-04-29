/* LeetCode Problem: (349) Intersection of two Arrays */

import java.util.*;

public class Day4Main{
    public static int[] intersection(int[] nums1, int[] nums2){
        int maxNum = Integer.MIN_VALUE;
        // Firstly, we find the maximum number in both the arrays combined.
        for(int i=0; i<nums1.length; i++){
            if(nums1[i]>maxNum){
                maxNum = nums1[i];
            }
        }
        for(int i=0; i<nums2.length; i++){
            if(nums2[i]>maxNum){
                maxNum = nums2[i];
            }
        }
        /* Then we make two Frequency arrays (of length equal to Maximum in both those arrays)
           which calculate the frequency of each number in both nums1 and nums2. */
        int[] count1 = new int[maxNum+1];
        int[] count2 = new int[maxNum+1];
        for(int i=0; i<nums1.length; i++){
            count1[nums1[i]]++;
        }
        for(int i=0; i<nums2.length; i++){
            count2[nums2[i]]++;
        }
        /* Then we make another array which is going to be the answer array containing the numbers
           which are present in both the arrays. */
        int anslen = Math.min(nums1.length, nums2.length);
        int[] ans = new int[anslen]; // The length of ans will be the minimum of length of both the arrays.
        int idx=0;
        for(int i=0; i<count1.length; i++){
            if(count1[i]>0 && count2[i]>0){  // Main Logic
                ans[idx]=i;  /* This is really important minute step
                                (I want to store value 2 on the index position of 0
                                but due to the loop iterations I was not able to do so.
                                So I introduced a new index which will start from 0 and
                                only when I am adding a new element to the answer array) */
                idx++;
            }
        }
        return Arrays.copyOf(ans,idx);  /* copyOf -> returns the copy of an array
                                                     up to a specific length (idx here) */
    }

    public static void main(String[] args){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
        // toString -> will return the String version of the array (used when we want to print an array)
    }
}

/* Logic: Firstly, We find the maximum number in both the arrays combined.
          Then we make two Frequency arrays (of length equal to Maximum in both those arrays)
          which calculate the frequency of each number in both nums1 and nums2.
          Then we make another array which is going to be the answer array containing the numbers
          which are present in both the arrays that we are going to print.
          Now, [Main Logic is that if the count of any number from both the arrays is greater than 0
          that means that the number is present in both the arrays]
          Then just print the ans array.*/