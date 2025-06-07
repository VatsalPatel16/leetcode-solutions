package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int majorityElement(int[] nums) {
        // Moore's Voting Algorithm
        // Initialize num as -1 and cnt as 0
        int num = -1, cnt = 0;

        // Iterate over array
        for (int n : nums) {
            // If current element is equal to num then increment cnt
            if (num == n)
                cnt++;
            // If not and cnt is equal to 0 then put current element in num
            // and increment cnt
            else if (cnt == 0) {
                num = n;
                cnt++;
            }
            // Otherwise decrement cnt
            else
                cnt--;
        }

        return num;
    }
}