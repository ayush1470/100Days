/* LeetCode Problem: (1432): Max Difference You Can Get From Changing an Integer */

public class Day74Main{
    public static int maxDiff(int num) {
        String s = Integer.toString(num);
        char[] chars = s.toCharArray();

        // Step 1: Maximize by replacing first non-'9' digit with '9'
        char toReplaceMax = 0;
        for (char c : chars) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        String maxStr = (toReplaceMax == 0) ? s : s.replace(toReplaceMax, '9');

        // Step 2: Minimize
        char toReplaceMin = 0;
        char replaceWithMin = 0;
        if (chars[0] != '1') {
            toReplaceMin = chars[0];
            replaceWithMin = '1';
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != '0' && chars[i] != '1') {
                    toReplaceMin = chars[i];
                    replaceWithMin = '0';
                    break;
                }
            }
        }
        String minStr = (toReplaceMin == 0) ? s : s.replace(toReplaceMin, replaceWithMin);
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }

    public static void main(String[] args){
        int num = 123456;
        System.out.println(maxDiff(num));
    }
}


/* Key Logic:
1. Convert the number to string to analyze and modify digits easily.
2. For maximum value:
   - Find the first digit that is not '9' and replace all its occurrences with '9'.
   - This maximizes the number since '9' is the largest possible digit.
3. For minimum value:
   - If the first digit is not '1', replace all its occurrences with '1' to ensure a valid leading digit and minimize the number.
   - Else, look for the first digit (after the first position) that is neither '0' nor '1' and replace all its occurrences with '0'.
   - This avoids invalid numbers with leading zero and ensures smallest valid value.
4. Return the difference between the maximized and minimized number.

Points:
- Ensures no leading zero occurs in the minimized number.
- Only one digit is replaced throughout the number for both max and min.
- Handles edge cases like all digits being '9' or '1' properly.
*/
