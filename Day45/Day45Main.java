/* LeetCode Problem: (904) Fruit Into Baskets */

import java.util.*;

public class Day45Main{
    public static int totalFruit(int[] fruits){
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxFruits = 0;

        for(int right = 0; right < fruits.length; right++){
            int fruit = fruits[right];
            basket.put(fruit, basket.getOrDefault(fruit, 0) + 1);

            // Shrink the window if we have more than 2 types
            while(basket.size() > 2){
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                if(basket.get(leftFruit) == 0){
                    basket.remove(leftFruit);
                }
                left++;
            }
            // Update the max number of fruits
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits1 = {1, 2, 1};
        int[] fruits2 = {0, 1, 2, 2};
        int[] fruits3 = {1, 2, 3, 2, 2};

        System.out.println(totalFruit(fruits1));
        System.out.println(totalFruit(fruits2));
        System.out.println(totalFruit(fruits3));
    }
}

/* Key Logic: - Use a sliding window approach to find the longest subarray with at most two types
                of fruits.
              - A HashMap is used to store the count of each fruit type currently in the window.
              - Expand the right end of the window by iterating over the array.
              - If the number of fruit types in the HashMap exceeds two, shrink the window from
                the left.
              - Decrease the count of the leftmost fruit, and remove it from the map if its count
                becomes zero.
              - After every iteration, update the maximum window size (maxFruits) if the current
                window is larger.
              - The window [left, right] always contains at most two types of fruits, ensuring the
                basket rule is followed. */
