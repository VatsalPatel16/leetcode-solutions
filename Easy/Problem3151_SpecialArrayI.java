package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;

        // if array has only one element that means array is special
        if (n == 1)
            return true;

        // Iterate over nums array
        for (int i = 0; i < n - 1; i++) {
            // parity p1 for current element
            int p1 = nums[i] % 2;
            // parity p2 for next element
            int p2 = nums[i + 1] % 2;
            // if both parities are same then array is not special return false
            if (p1 == p2)
                return false;
        }
        // otherwise array is special return true
        return true;
    }
}