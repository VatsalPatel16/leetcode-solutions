package Medium;

// Time Complexity: O(m * n), where m = number of rows and n = number of columns
// Space Complexity: O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        // Getting row and column using matrix
        int row = matrix.length, col = matrix[0].length;
        // flag variables to check if first row or column contains zero or not
        boolean isFirstRowZero = false, isFirstColZero = false;

        // loops to check for first row and first column contains zero or not
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        // Using first row and column as a marker
        // if found 0 at i, j mark that row and column as zero
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Updating matrix using markers
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Checking if first row is zero or not
        if (isFirstRowZero) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

        // Checking if first column is zero or not
        if (isFirstColZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}