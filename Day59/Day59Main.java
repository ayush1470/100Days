/* LeetCode Problem: (241) Different Ways to Add Parentheses */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
    public static List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return helper(expression, memo);
    }
    private static List<Integer> helper(String input, Map<String, List<Integer>> memo) {
        if (memo.containsKey(input)) return memo.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = helper(input.substring(0, i), memo);
                List<Integer> right = helper(input.substring(i + 1), memo);
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') res.add(l + r);
                        else if (c == '-') res.add(l - r);
                        else res.add(l * r);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        memo.put(input, res);
        return res;
    }

    public static void main(String[] args){
        String expression = "2-1-1";
        System.out.println(diffWaysToCompute(expression));
    }
}

/* Key Logic: - This solution recursively explores all ways to add parentheses in the expression.
            - For each operator in the string, we divide the expression into left and right
              subexpressions.
            - We recursively compute all possible results for each subexpression.
            - Then, we combine every result from the left with every result from the right using the
              current operator.
            - If the expression is a pure number (no operator), we parse it and return it as the only
              result.
            - To avoid redundant computations, we use memoization (HashMap) to store and reuse results
              for subexpressions. */
