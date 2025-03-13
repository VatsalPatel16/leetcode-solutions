package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1, maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            // if current element is greater than prev element then
            // increment inc and reset dec to 1
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            }
            // else if current element is less than prev element then
            // increment dec and reset inc to 1
            else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            }
            // else reset both inc and dec
            else {
                inc = 1;
                dec = 1;
            }
            // update maxLen
            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }

        return maxLen;
    }
}