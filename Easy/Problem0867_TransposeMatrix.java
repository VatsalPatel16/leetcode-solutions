package Easy;

// Time Complexity: O(n * m)
// Space Complexity: O(m * n)
class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        // res array for output. It's size will be m * n
        int[][] res = new int[m][n];

        // outer loop
        for (int r = 0; r < n; r++) {
            // inner loop
            for (int c = 0; c < m; c++) {
                // res[c][r] will be matrix[r][c]
                res[c][r] = matrix[r][c];
            }
        }

        return res;
    }
}