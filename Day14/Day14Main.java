/* LeetCode Problem: (258) Add Digits */

public class Day14Main {
    public static int addDigits(int num) {
        if (num == 0){
            return 0;
        }
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args){
        int num = 38;
        System.out.println(addDigits(num));
    }
}

/* Key Logic: Digital Root Concept:
              The digital root of a number is the single-digit value obtained
              by repeatedly summing its digits.
              digital_root(num) = 1 + (num − 1) % 9  (if num > 0)
              The digital root of a number can be found in O(1) time using:
              1 + (num - 1) % 9, which works for all positive numbers.
              This formula is based on properties of modulo 9 arithmetic.
              Special case: if num is 0, return 0 directly. */