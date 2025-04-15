package Easy;

// Time Complexity: O(1), Because the number of steps is bounded by a constant (even if input is huge).
// Time Complexity(Theoretical): O(K), Where K is the number of unique states before reaching 1 or cycle (but K is at most ~243 for int range).
// Space Complexity: O(1)
class Solution {
    public boolean isHappy(int n) {
        // Two pointers fast and slow
        int fast = n, slow = n;

        // move slow pointer one step
        // and fast pointer two steps
        // while fast is not equal to 1 and slow is not equal to fast do so
        do {
            slow = squareOfNum(slow);
            fast = squareOfNum(squareOfNum(fast));
        } while (fast != 1 && slow != fast);

        // if fast is equal to 1 then return true otherwise return false
        return fast == 1;
    }

    // Helper function to find sum of square of given num's digits
    private int squareOfNum(int num) {
        int res = 0;
        while (num > 0) {
            int digit = num % 10;
            res += digit * digit;
            num /= 10;
        }

        return res;
    }
}