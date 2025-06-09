/* LeetCode Problem: (56) Merge Intervals */

import java.util.*;

public class Day62Main{
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort intervals based on the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // If current interval overlaps with the next one
            if (current[1] >= intervals[i][0]) {
                // Merge them by updating the end time
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Add current interval and move to next
                merged.add(current);
                current = intervals[i];
            }
        }

        // Add the last interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] input1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result1 = merge(input1);
        System.out.println(Arrays.deepToString(result1)); // [[1, 6], [8, 10], [15, 18]]
    }
}

/* Key Logic: - Check if only one or no interval is present, return as is.
              - Sort the intervals based on the start time to handle them in order.
              - Initialize a list to store merged intervals and a variable for the current interval.
              - Loop through the intervals:
                - If the current interval overlaps with the next, merge them by updating the end time.
                - If they don't overlap, add the current interval to the result and move to the next.
              - After the loop, add the last interval to the result.
              - Convert the list of merged intervals to a 2D array and return it. */
