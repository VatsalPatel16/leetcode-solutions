package Medium;

import java.util.*;

// Time Complexity: O(n log n)
// Space Complexity: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        // ArrayList to store output
        List<int[]> al = new ArrayList<>();

        // sorting array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Adding first element from intervals in al
        al.add(new int[] { intervals[0][0], intervals[0][1] });

        for (int i = 1; i < len; i++) {
            // Getting last element from arraylist
            int[] last = al.get(al.size() - 1);
            // curr array for current element
            int[] curr = intervals[i];

            // if found overlapping interval then update last
            if (last[1] >= curr[0]) {
                last[1] = Math.max(last[1], curr[1]);
            }
            // otherwise add that element in list
            else {
                al.add(new int[] { curr[0], curr[1] });
            }
        }
        // Converting it to 2d array
        int[][] res = al.toArray(new int[al.size()][]);

        return res;
    }
}