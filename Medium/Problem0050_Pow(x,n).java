package Medium;

// Time Complexity: O(log n)
// Space Complexity: O(log n)
class Solution {
    public double myPow(double x, int n) {
        // Base case - any number raised to power 0 is 1
        if (n == 0)
            return 1;
        // converting int n to long to handle case where n = -2147483648
        long exp = n;

        // Handling negative exponent by taking reciprocal of x
        // Also changing exp into positive
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        // Computing myPow(x, exp / 2) recursively
        double half = myPow(x, (int) (exp / 2));

        // if exp is even then return half * half
        if (exp % 2 == 0) {
            return half * half;
        }
        // else return x * half * half
        else {
            return x * half * half;
        }
    }
}