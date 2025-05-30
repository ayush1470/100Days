import java.util.*;

public class Day52Main{
    public static String largestNumber(int[] nums){
        // Convert int[] to String[]
        String[] strNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to sort in a way that creates the largest number
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If after sorting the largest number is "0", the entire number is zero
        if(strNums[0].equals("0")) return "0";

        // Join all numbers to form the result
        StringBuilder result = new StringBuilder();
        for(String str : strNums){
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args){
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Output: " + largestNumber(nums2));
    }
}

/* Key Logic: - The goal is to arrange integers in such a way that their concatenation yields the
                'largest possible number'.
              - Convert each integer in the array to a string to enable custom sorting based on
                string comparison.
              - Use a custom comparator to sort the strings:
                  - For two strings `a` and `b`, compare `(b + a)` with `(a + b)`.
                  - This ensures that the combination yielding the larger concatenated number comes
                    first.
                  - Example: To decide between "3" and "30", compare "330" and "303" → "330" is greater,
                    so "3" comes before "30".
              - After sorting, check if the first string is "0":
                  - If it is, all numbers are zeros (like [0,0,0]), so return "0".
              - Finally, concatenate all sorted strings to form the result.
              - This approach ensures a greedy, lexicographical order that guarantees the largest number. */

