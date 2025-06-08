/* LeetCode Problem: (796) Rotate String */

public class Day61Main{
    public static boolean rotateString(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }
        StringBuilder Str = new StringBuilder();
        Str.append(s);
        Str.append(s);
        return Str.toString().contains(goal);
    }

    public static void main(String[] args){
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }
}

/* Key Logic: - First, check if the lengths of the original string `s` and target string `goal` are equal.
              - If not equal, return false immediately, since rotation is impossible.
              - Append string `s` to itself, forming a new string that includes all possible rotations
                of `s`.
              - Check if `goal` exists as a substring within the doubled string (`s + s`).
              - If it does, return true, meaning `goal` is a valid rotation of `s`; otherwise,
                return false. */

