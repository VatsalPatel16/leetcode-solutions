package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        // xorNums to store xor of elements of nums
        // xorRange to store xor of range 0 to (nums.length + 1)
        int xorNums = 0, xorRange = 0;

        // storing xor of elements of nums in variable xorNums
        for (int num : nums) {
            xorNums ^= num;
        }

        // xor of range 0 to (nums.length + 1)
        for (int i = 0; i < nums.length + 1; i++) {
            xorRange ^= i;
        }

        // and xor operation between xorNums and xorRange will give the answer
        return xorNums ^ xorRange;
    }
}