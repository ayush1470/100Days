/* LeetCode Problem: (48) Rotate Image */

public class Day64Main{
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap rows with columns)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                // Swap elements in the row
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // Helper method to print the matrix (for testing)
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix1);
        printMatrix(matrix1);

        System.out.println();

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix2);
        printMatrix(matrix2);
    }
}

/* Key Logic: - Step 1: Transpose the matrix by swapping matrix[i][j] with matrix[j][i] for all i < j.
                This converts rows into columns.
              - Step 2: Reverse each row to complete the 90-degree clockwise rotation.
                This swaps elements from both ends of each row towards the center.
              - Both operations are done in-place, without using extra memory. */
