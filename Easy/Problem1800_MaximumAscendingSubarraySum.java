package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int maxAscendingSum(int[] nums) {
        // Initialize sum and max to keep track of maximum sum
        int sum = nums[0], max = nums[0];

        // Iterate over array
        for (int i = 1; i < nums.length; i++) {
            // if current element is greater than previous element then add it to sum
            // and update max
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
                max = Math.max(max, sum);
            }
            // Otherwise update sum to current element
            else {
                sum = nums[i];
            }
        }
        return max;
    }
}