package Easy;

// Time Complexity: O(n + 51) so it is equal to O(n)
// Space Complexity: O(51) which is equal to O(1)
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        // freq array of size 51 to store frequency of each num
        // since constraints is that 1 <= nums.length <= 50
        // and 1 <= nums[i] <= 50
        int[] freq = new int[51];
        int res = 0;

        // Iterate over nums array and store freq of each num
        for (int num : nums) {
            freq[num]++;
        }

        // in freq array if any value's frequency is two then xor it with res
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2) {
                res ^= i;
            }
        }

        return res;
    }
}