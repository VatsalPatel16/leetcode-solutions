package Medium;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int longestSubarray(int[] nums) {
        // finding the max element from the nums array
        int max = 0;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }

        // count variable to store how many times we have seen
        // max element in a contiguous sequence
        int count = 0, ans = 1;
        for (int i = 0; i < nums.length; i++) {
            // if current element is equal to max then increment count
            if (nums[i] == max) {
                count++;
            }
            // if not then set it to 0
            else {
                count = 0;
            }
            // maximize the ans
            ans = Math.max(count, ans);
        }
        return ans;
    }
}