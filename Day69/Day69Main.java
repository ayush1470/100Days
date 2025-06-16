/* LeetCode Problem: (168): Excel Sheet Column Title */

public class Day69Main{
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Decrement to make it 0-indexed
            int remainder = columnNumber % 26;
            char ch = (char) (remainder + 'A');
            sb.append(ch);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701)); // Output: ZY
    }
}

/* Key Logic: - Treat the column number like a base-26 number but without a zero digit
                (1 to 26 corresponds to A-Z).
              - We subtract 1 from the columnNumber to make it zero-based.
              - Then we repeatedly find the remainder when divided by 26 and map it to a character
                ('A' to 'Z').
              - Append the characters and reverse the final string to get the correct title. */
