package Medium;

// Time Complexity: O(rows * cols)
// Space Complexity: O(1)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // Getting number of rows and cols from the given matrix
        int rows = mat.length, cols = mat[0].length;
        // Using variables row, col, dir to traverse diagonally
        int row = 0, col = 0, dir = 1;
        // res to store output
        int[] res = new int[rows * cols];

        // Iterate over matrix
        for (int i = 0; i < rows * cols; i++) {
            // first store res[i] from mat[row][col]
            res[i] = mat[row][col];

            // dir equal to 1 means upward direction
            if (dir == 1) {
                // boundary check for col
                if (col == cols - 1) {
                    row++;
                    dir = -1;
                }
                // bondary check for row
                else if (row == 0) {
                    col++;
                    dir = -1;
                }
                // otherwise update the row to row-- and col to col++
                else {
                    row--;
                    col++;
                }
            }
            // dir equal to -1 means downward direction
            else if (dir == -1) {
                // boundary check for row
                if (row == rows - 1) {
                    col++;
                    dir = 1;
                }
                // boundary check for col
                else if (col == 0) {
                    row++;
                    dir = 1;
                }
                // otherwise update the row to row++ and col to col--
                else {
                    row++;
                    col--;
                }
            }
        }

        return res;
    }
}