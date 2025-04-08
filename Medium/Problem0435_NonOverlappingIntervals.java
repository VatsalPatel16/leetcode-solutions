package Medium;

import java.util.Arrays;

// Time Complexity: O(n log n) (due to sorting of intervals array)
// Space Complexity: O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0; // res to store output

        // Sorting intervals array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize end as intervals[0][1]
        int end = intervals[0][1];
        // loop from second element till last
        for (int i = 1; i < intervals.length; i++) {
            // If found overlap then increment res and update end
            if (intervals[i][0] < end) {
                res++;
                end = Math.min(end, intervals[i][1]);
            }
            // otherwise only update end
            else {
                end = intervals[i][1];
            }
        }

        return res;
    }
}