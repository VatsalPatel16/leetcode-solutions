package Medium;

// Time Complexity: O(32 * n) ≈ O(n), Constant factor loop over bits.
// Space Complexity: O(1), No extra memory used apart from counters.
class Solution {
    public int totalHammingDistance(int[] nums) {
        // res to store output
        int n = nums.length, res = 0;

        // Iterate over each bit from right to left
        for (int i = 0; i < 32; i++) {
            // countOfOnes to keep track of how many bits are one
            // for current iteration
            int countOfOnes = 0;
            for (int num : nums) {
                // using right shift and bit mask to check each bit
                // if bit is one then increment count of ones
                if ((num >> i & 1) == 1) {
                    countOfOnes++;
                }
            }
            // add countOfOnes * countOfZeros(here it is (n - countOfOnes)) in res
            res += countOfOnes * (n - countOfOnes);
        }

        return res;
    }
}