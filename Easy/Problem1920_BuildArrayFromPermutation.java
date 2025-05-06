package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    // Follow up: using O(1) memory
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        // Because numbers are in range 0 to n - 1, we can use that
        // First encode the value in same place
        // Storing both values in one index
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        // Then divide each number by n to extract the answer
        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }

        return nums;
    }
}