package Easy;

// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int addDigits(int num) {
        // variable sum to store sum of each digit from num
        int sum = 0;

        // while num is greater than or equal to 10 do so
        while (num >= 10) {
            // another loop to get each digit and its sum
            while (num > 0) {
                sum = sum + (num % 10);
                num /= 10;
            }
            // after that set num = sum
            num = sum;
            // and reset sum to 0 for next iteration
            sum = 0;
        }

        return num;
    }
}