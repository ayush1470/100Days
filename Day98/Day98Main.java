/* LeetCode Problem: (848): Shifting Letters */

public class Day98Main{
    public static String shiftingLetters(String s, int[] shifts) {
        char[] res = s.toCharArray();
        long totalShifts = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            totalShifts = (totalShifts + shifts[i]) % 26;
            res[i] = (char) ('a' + (res[i] - 'a' + totalShifts) % 26);
        }

        return new String(res);
    }

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3,5,9};
        System.out.println(shiftingLetters(s,shifts));
    }
}