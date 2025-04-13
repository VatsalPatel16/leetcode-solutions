package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        // res variable to store output
        int res = 0;

        // Iterate over given array nums
        // using xor operation to get that single number which only appear once
        // 0 ^ 0 = 0
        // 0 ^ 1 = 1
        // 1 ^ 0 = 1
        // 1 ^ 1 = 0
        for (int n : nums) {
            res ^= n;
        }

        return res;
    }
}