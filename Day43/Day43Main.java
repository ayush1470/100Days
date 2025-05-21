/* LeetCode Problem: (1732) Find the Highest Altitude */

public class Day43Main{
    public static int largestAltitude(int[] gain){
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int g : gain){
            currentAltitude += g;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }

    public static void main(String[] args){
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println("Output: " + largestAltitude(gain1)); // Output: 1

        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Output: " + largestAltitude(gain2)); // Output: 0
    }
}

/* Key Logic: - The biker starts at altitude 0.
              - We maintain a variable `currentAltitude` to track the biker’s current height.
              - As we iterate through the `gain` array:
                - Add each `gain[i]` to `currentAltitude` to simulate altitude change.
                - Track the highest altitude reached using `maxAltitude = Math.max(maxAltitude,
                  currentAltitude)`.
              - Return `maxAltitude` after processing all gains.
              - This gives the maximum altitude the biker reaches during the trip. */

