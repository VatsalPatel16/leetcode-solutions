package Medium;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // if only one element in the nums then return the value itself
        // because that will be maximum amount thief can loot.
        if (n == 1) {
            return nums[0];
        }

        // Two variables prev2 and prev1
        int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]);

        // Iterate over nums array
        for (int i = 2; i < n; i++) {
            // get the curr value as max(prev1, nums[i] + prev2)
            int curr = Math.max(prev1, nums[i] + prev2);
            // at each iteration set prev2 as prev1
            prev2 = prev1;
            // and prev1 as curr
            prev1 = curr;
        }

        // prev1 will be our answer
        return prev1;
    }
}