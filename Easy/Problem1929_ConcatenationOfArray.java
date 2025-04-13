package Easy;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n]; // ans array of 2n length

        // Iterate from 0 to n
        for (int i = 0; i < n; i++) {
            // Adding element in two positions(i and (i + n)) at the same time
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}
