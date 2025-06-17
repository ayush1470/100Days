/* LeetCode Problem: (8): String to Integer (atoi) */

public class Day70Main{
    public static int atoi(String s){
        int i=0, result=0, sign=1;
        int n = s.length();
        while(i<n && s.charAt(i) == ' '){
            i++;
        }
        if(i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }

    public static void main(String[] args){
        String s = "-1233445abf";
        System.out.println(atoi(s));
    }
}

/* Key Logic: - Skip all leading whitespaces from the input string.
              - Detect and store the sign (+ or -), if present.
              - Parse numeric digits one-by-one, building the result.
              - Before appending a new digit, check for potential overflow using:
                  result > (Integer.MAX_VALUE - digit) / 10
              - If overflow is detected, return Integer.MAX_VALUE or Integer.MIN_VALUE accordingly.
              - Return the final integer result with the correct sign. */
