/* LeetCode Problem: (202) Happy Number */

import java.util.*;

public class Day8Main{
    public static int getDigitSquareSum(int n, int ans){
        if(n==0){
            return ans;
        }
        int digit = n % 10;
        ans+=digit*digit;
        n = n / 10;
        return getDigitSquareSum(n,ans);
    }

    public static boolean isHappy(int n){
        Set<Integer> seen = new HashSet<>();  /* stores the numbers which have already
                                                 been seen to avoid infinite loop */
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n = getDigitSquareSum(n,0);
        }
        return n==1;  // if n==1 true, else false
    }

    public static void main(String[] args){
        int n = 19;
        System.out.println(isHappy(n));
    }
}

/*
    KEY LOGIC (Happy Number Detection):

    - A number is called a "Happy Number" if repeatedly replacing it with the
      sum of the squares of its digits eventually leads to 1.

    - If during this process the number falls into a loop (i.e., you see a number
      you've already seen before), it will never reach 1 — so it's not a happy number.

    - To detect this loop, we use a HashSet to store all previously seen numbers.
      If we encounter a number again, it means we're in a cycle → return false.

    - The DigitSquareSum function is used to recursively calculate the sum of squares
      of the digits of a number.

    Example:
      n = 19 → 1² + 9² = 82
      82 → 8² + 2² = 68
      68 → 6² + 8² = 100
      100 → 1² + 0² + 0² = 1 → Happy Number
*/