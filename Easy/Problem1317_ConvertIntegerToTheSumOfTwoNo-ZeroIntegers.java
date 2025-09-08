package Easy;

// Time Complexity: O(n log n)
// Space Complexity: O(1)
class Solution {
    public int[] getNoZeroIntegers(int n) {
        // Variables a and b to store No-zero integers
        int a = 0, b = 0;

        // Iterate from 1 to n
        for (int i = 1; i < n; i++) {
            // set i as a and b as (n - i)
            a = i;
            b = n - i;

            // checking if both numbers are no-zero or not
            // if yes then break out the loop
            if (isNoZero(a) && isNoZero(b)) {
                break;
            }
        }

        // return a and b in the form of array
        return new int[] { a, b };
    }

    // isNoZero function will check if num contains 0 or not
    // if num contains zero then it will return false otherwise true
    private boolean isNoZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num /= 10;
        }

        return true;
    }
}