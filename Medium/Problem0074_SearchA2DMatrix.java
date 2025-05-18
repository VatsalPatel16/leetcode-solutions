package Medium;

// Time Complexity: O(m + n), where m = number of rows, n = number of columns
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // pointer i at first row and j at last element of first row
        int i = 0, j = matrix[0].length - 1;

        // while i is less than length of matrix and j is greater than or equal to zero
        // do so
        while (i < matrix.length && j >= 0) {
            // if element at i, j is equal to target return true
            if (matrix[i][j] == target)
                return true;

            // else if element at i, j is less than target then update i
            else if (matrix[i][j] < target)
                i++;

            // otherwise update j
            else
                j--;
        }

        // if not found target return false
        return false;
    }
}