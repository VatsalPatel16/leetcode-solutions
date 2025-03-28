package Easy;

import java.util.Arrays;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        // total sum of element of array nums
        int totalSum = Arrays.stream(nums).sum();
        // Initialize leftSum variable as 0
        int leftSum = 0;

        // Iterate from index 0 to last index
        for (int i = 0; i < n; i++) {
            // calculate rightSum for the current element
            int rightSum = totalSum - leftSum - nums[i];

            // if leftSum equal to rightSum then found pivot index
            if (leftSum == rightSum) {
                return i;
            }

            // update leftSum
            leftSum += nums[i];
        }

        // if not found return -1
        return -1;
    }
}