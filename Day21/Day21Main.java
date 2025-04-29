/* LeetCode Problem: (696) Count Binary Substrings */

public class Day21Main {
    public static int countBinarySubstrings(String s) {
        int prevRun = 0, currRun = 1, result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currRun++;
            } else {
                result += Math.min(prevRun, currRun);
                prevRun = currRun;
                currRun = 1;
            }
        }

        result += Math.min(prevRun, currRun);
        return result;
    }

    public static void main(String[] args) {
        String s = "10101";
        System.out.println(countBinarySubstrings(s)); // Output: 4
    }
}

/* Key Logic: - We count the lengths of consecutive groups of 0s or 1s.
              - Each time we switch from one digit to another, we add the minimum of the previous
                group length and the current group length.
              - This is because a valid binary substring can only be as long as the smaller of the
                two consecutive groups.
                For example: "0011" → prevRun = 2, currRun = 2 → min(2,2) = 2 substrings: "0011", "01"
              - At the end, we add one last min(prevRun, currRun) to account for the final pair of groups.
              - This approach runs in O(n) time and uses O(1) space. */