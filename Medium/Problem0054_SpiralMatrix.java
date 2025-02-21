package Medium;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(m * n)
// Space Complexity: O(1) (excluding output list)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // res list to store output
        List<Integer> res = new ArrayList<>();

        // 4 layers top, bottom, left, right
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        // While pointers don't cross each other do so
        while (top <= bottom && left <= right) {
            // Iterate from left to right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            // Iterate from top to bottom
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            // Iterate from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Iterate from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
