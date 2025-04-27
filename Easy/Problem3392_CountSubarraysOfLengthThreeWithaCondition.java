package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    // Condition: return the number of subarrays of length 3 such that
    // the sum of the first and third numbers equals exactly half of the second
    // number.
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        // res to store output
        int res = 0;

        // iterate over nums array from 0 to (i <= n - 3)
        for (int i = 0; i <= n - 3; i++) {
            // if the subarray follows the condition given in the problem
            // in that case increment result
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                res++;
            }
        }

        return res;
    }
}