package Medium;

import java.util.Arrays;

// Time Complexity: O(n log n)
// Space Complexity: O(n)
class Solution {
    public int numSubseq(int[] nums, int target) {
        // First sort the array
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int n = nums.length;

        // precompute pow from 0 to n and store it in pow array
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        // res to store output
        int res = 0;
        // and i, j pointers
        int i = 0, j = n - 1;

        // while i is less than or equal to j do so
        while (i <= j) {
            // if value at i plus value at j in nums
            // is less than or equal to target update the res
            // and increment i pointer
            if (nums[i] + nums[j] <= target) {
                res = (res + pow[j - i]) % mod;
                i++;
            }
            // otherwise decrement j pointer
            else {
                j--;
            }
        }

        return res;
    }
}