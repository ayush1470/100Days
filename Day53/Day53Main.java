/* LeetCode Problem: (1352) Product of the Last K Numbers */

import java.util.*;

public class Day53Main{
    private List<Integer> prefixProducts;

    public Day53Main(){
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Start with 1 for easier multiplication
    }

    public void add(int num) {
        if (num == 0) {
            // Reset if zero is added, as product becomes zero
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProducts.size();
        if (k >= size) {
            // A zero was encountered within last k elements
            return 0;
        }
        int numerator = prefixProducts.get(size - 1);
        int denominator = prefixProducts.get(size - 1 - k);
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Day53Main obj = new Day53Main();

        obj.add(3);                      // [3]
        obj.add(0);                      // [3, 0]
        obj.add(2);                      // [3, 0, 2]
        obj.add(5);                      // [3, 0, 2, 5]
        obj.add(4);                      // [3, 0, 2, 5, 4]
        System.out.println(obj.getProduct(2)); // Output: 20 (5*4)
        System.out.println(obj.getProduct(3)); // Output: 40 (2*5*4)
        System.out.println(obj.getProduct(4)); // Output: 0 (0 in range)
        obj.add(8);                      // [3, 0, 2, 5, 4, 8]
        System.out.println(obj.getProduct(2)); // Output: 32 (4*8)
    }
}

/* Key Logic: - Use prefix products to store cumulative product up to each index.
              - When a zero is added, reset the prefix list, since any product involving it becomes zero.
              - To get the product of last k elements, divide the latest prefix product by the prefix
                product before those k elements.
              - If k is greater than or equal to prefixProducts.size(), that means a zero was added
                in that range, so return 0.
              - Both add and getProduct operations work in O(1) time. */
