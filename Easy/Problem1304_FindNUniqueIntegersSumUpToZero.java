package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1) (Excluding output)
class Solution {
    public int[] sumZero(int n) {
        // res array to store output
        int[] res = new int[n];
        // val to add (+val, -val) in the res array to make sum zero
        int val = 1;

        // Iterate from 0 to n - 1
        // This will handle both odd and even case of n
        for (int i = 0; i < n - 1; i += 2) {
            // set val at ith position and -val at (i + 1)
            res[i] = val;
            res[i + 1] = -val;
            // increment val
            val++;
        }

        return res;
    }
}