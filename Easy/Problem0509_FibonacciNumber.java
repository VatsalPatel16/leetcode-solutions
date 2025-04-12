package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int fib(int n) {
        // if n is equal to 0 in that case return 0
        if (n == 0) {
            return 0;
        }

        // Initialize val0 as 0 and val1 as 1
        int val0 = 0, val1 = 1;

        // Iterate from i is equal to 2 to (i <= n)
        for (int i = 2; i <= n; i++) {
            // calculate curr using val0 and val1
            int curr = val0 + val1;
            // at each iteration set val0 as val1
            val0 = val1;
            // and val1 as curr
            val1 = curr;
        }

        // at last val1 will be our answer
        return val1;
    }
}