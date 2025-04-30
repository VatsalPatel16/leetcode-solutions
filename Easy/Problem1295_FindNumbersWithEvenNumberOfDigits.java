package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int findNumbers(int[] nums) {
        // res to store output
        int res = 0;

        // go through each number in the nums array
        for (int n : nums) {
            // digits variable to keep track of number of digits of current n
            int digits = 0;
            // while n is greater then 0 do so
            while (n > 0) {
                // divide n by 10
                n /= 10;
                // and increment digits
                digits++;
            }
            // if number of digits are even then increment res
            if (digits % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}