package Medium;

// Time Complexity: O(m + n), where m = number of rows and n = number of columns
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // i pointer for row and j for column
        int i = 0, j = matrix[0].length - 1;

        // while i is less than length of matrix and
        // j is greater than or equal to 0 do so
        while (i < matrix.length && j >= 0) {
            // if current element is equal to target return true
            if (matrix[i][j] == target)
                return true;

            // or else current element is less than target then update i
            else if (matrix[i][j] < target)
                i++;

            // otherwise update j
            else
                j--;
        }

        // if not found then return false
        return false;
    }
}