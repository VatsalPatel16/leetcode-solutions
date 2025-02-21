package Medium;

// Time Complexity: O(n^2)
// Space Complexity: O(1) (excluding output matrix)
class Solution {
    public int[][] generateMatrix(int n) {
        // Output matrix
        int[][] res = new int[n][n];
        int num = 1; // num variable to store element in res from 1 to n^2

        // Boundaries of matrix (top, bottom, left, right)
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        // While pointers don't cross each other do so
        while (top <= bottom && left <= right) {
            // Traverse from left to right and increment top
            for (int i = left; i <= right; i++) {
                res[top][i] = num;
                num++;
            }
            top++;

            // Traverse from top to bottom and decrement right
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num;
                num++;
            }
            right--;

            // Traverse from right to left and decrement bottom
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num;
                num++;
            }
            bottom--;

            // Traverse from bottom to top and increment left
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num;
                num++;
            }
            left++;
        }

        return res;
    }
}
