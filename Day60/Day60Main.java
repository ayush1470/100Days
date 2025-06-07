/* LeetCode Problem: (394) Decode String */

public class Day60Main {
    private static int index = 0;

    public static String decodeString(String s) {
        index = 0;  // Reset index to parse fresh input
        return decode(s);
    }

    private static String decode(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        while (index < n) {
            char current = s.charAt(index);
            if (Character.isDigit(current)) {
                int k = 0;
                while (Character.isDigit(s.charAt(index))) {
                    k = k * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++; // skip '['
                String decodedString = decode(s);
                index++; // skip ']'
                for (int i = 0; i < k; i++) {
                    result.append(decodedString);
                }
            } else if (current == ']') {
                break;
            } else {
                result.append(current);
                index++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "3[a]2[bc]";
        String input2 = "3[a2[c]]";
        String input3 = "2[abc]3[cd]ef";

        System.out.println(decodeString(input1)); // Output: aaabcbc
        System.out.println(decodeString(input2)); // Output: accaccacc
        System.out.println(decodeString(input3)); // Output: abcabccdcdcdef
    }
}

/* Key Logic: - Use a global 'index' to track the current position in the string while parsing.
              - Parse digits to build the repeat count (k).
              - When encountering '[', recursively decode the substring inside the brackets.
              - When encountering ']', return the decoded substring to the previous call.
              - Append the decoded substring k times to the result.
              - Continue until the whole string is parsed. */
