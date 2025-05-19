/* LeetCode Problem: (1094) Car Pooling */

public class Day41Main{
    public static boolean carPooling(int[][] trips, int capacity){
        // We know that the maximum 'to' value can be 1000
        int[] stops = new int[1001]; // Index represents kilometers

        // Mark pickups and drop-offs
        for(int[] trip : trips){
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from] += numPassengers;  // pick up
            stops[to] -= numPassengers;    // drop off
        }

        // Simulate the journey
        int currentPassengers = 0;
        for(int i = 0; i < stops.length; i++){
            currentPassengers += stops[i];
            if(currentPassengers > capacity){
                return false;  // Exceeded car capacity
            }
        }
        return true;  // All trips are possible within capacity
    }

    public static void main(String[] args){
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;
        System.out.println(carPooling(trips1, capacity1));

        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        int capacity2 = 5;
        System.out.println(carPooling(trips2, capacity2));
    }
}

/* Key Logic: - Use a sweep line technique with a difference array to track passenger changes.
              - For each trip:
                   - Increment passengers at the pickup location.
                   - Decrement passengers at the drop-off location.
              - Traverse the stops from west to east:
                   - Keep a running total of current passengers.
                   - If passengers exceed capacity at any point, return false.
              - If the loop completes without exceeding capacity, return true. */
