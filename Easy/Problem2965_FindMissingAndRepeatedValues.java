package Easy;

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        // res array of size 2 to store output
        int[] res = new int[2];
        // freq array to store freq of each element of the grid
        int[] freq = new int[n * n];

        // Iterate over grid array to populate freq array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j] - 1] += 1;
            }
        }

        // Now find those two elements in the freq array with frequency 2 and 0
        // and store that in res array
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2) {
                res[0] = i + 1;
            } else if (freq[i] == 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }
}