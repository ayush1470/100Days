/* LeetCode Problem: (556): Next Greater Element III */

public class Day79Main{
    public static int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();

        // Step 1: Find the first decreasing digit from the right
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such digit is found, return -1
        if (i < 0) return -1;

        // Step 2: Find the next bigger digit on the right side of i
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap
        swap(digits, i, j);

        // Step 4: Reverse the digits after index i
        reverse(digits, i + 1, digits.length - 1);

        // Convert back to integer
        long val = Long.parseLong(new String(digits));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
        System.out.println(nextGreaterElement(21));
    }
}

/* Key Logic:
 - Traverse from right to left and find the first digit that is smaller than the digit next to it.
   Let's call its index 'i'.
 - If no such index is found, then the number is the highest possible permutation — return -1.
 - Otherwise, find the smallest digit on the right side of index 'i' that is larger than digits[i].
   Let's call its index 'j'.
 - Swap digits[i] with digits[j].
 - Reverse the part of the array to the right of index 'i' to get the next smallest permutation.
 - Convert the resulting character array back to a number.
 - If the result exceeds Integer.MAX_VALUE, return -1. */