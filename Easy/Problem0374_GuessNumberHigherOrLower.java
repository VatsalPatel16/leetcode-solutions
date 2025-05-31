package Easy;

// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution extends GuessGame {
    public int guessNumber(int n) {
        // Initialize l and r pointer
        int l = 1, r = n;

        // loop until both pointer don't cross each other
        while (l <= r) {
            int mid = l + (r - l) / 2; // getting mid

            // if we guess the right value then return it
            if (guess(mid) == 0)
                return mid;

            // else if guessed higher value then update r pointer
            else if (guess(mid) == -1)
                r = mid - 1;

            // Otherwise update l pointer
            else
                l = mid + 1;

        }

        return -1;
    }
}

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */