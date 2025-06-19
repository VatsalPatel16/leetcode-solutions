package Medium;

import java.util.Arrays;

// Time Complexity: O(n log n)
// Space Complexity: O(1)
class Solution {
    public int partitionArray(int[] nums, int k) {
        // Sorting the nums array
        Arrays.sort(nums);
        // variable count to store number of subsequences required
        int n = nums.length, count = 1;
        // and variable start
        int start = nums[0];

        // Iterate over nums array
        for (int i = 1; i < n; i++) {
            // if difference between current element and start is
            // greater than k then increment count and update start variable
            if (nums[i] - start > k) {
                count++;
                start = nums[i];
            }
        }

        return count;
    }
}