package Medium;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // first transpose of array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // then reverse matrix row by row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            // simple reverse array logic
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}