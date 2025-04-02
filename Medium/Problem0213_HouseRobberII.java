package Medium;

import java.util.Arrays;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // if only one element in the nums then
        // return that because that is the only house thief can rob.
        if (n == 1) {
            return nums[0];
        }
        // if two elements then return max of (nums[0], nums[1])
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // getting two loots using function maxLoot
        // 1. from index 1 to last
        // 2. from index 0 to last - 1
        int loot1 = maxLoot(Arrays.copyOfRange(nums, 1, n));
        int loot2 = maxLoot(Arrays.copyOfRange(nums, 0, n - 1));

        // max of these two loots will be our result
        return Math.max(loot1, loot2);
    }

    // House Robber problem code
    private int maxLoot(int[] nums) {
        int n = nums.length;
        int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}