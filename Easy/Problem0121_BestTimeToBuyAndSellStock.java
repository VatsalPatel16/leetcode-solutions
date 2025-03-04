package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        // Two pointer left and right
        int left = 0;
        int right = 1;
        // maxProfit variable to store output and if we can't achieve any profit
        // its value is set to 0
        int maxProfit = 0;

        // while right pointer is less than length of prices array do so
        while (right < prices.length) {
            // if value at left pointer is less than value at right pointer
            // maximize profit and update maxProfit variable
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }
            // otherwise update left pointer
            else {
                left = right;
            }
            // increment right pointer at each iteration
            right++;
        }
        return maxProfit;
    }
}