package Easy;

import java.util.*;

// Time Complexity: O((n + k) log n)
// Space Complexity: O(n)
class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Priority Queue to store gifts (Max heap)
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long res = 0;

        // Adding all gifts to heap
        for (long g : gifts) {
            pq.add(g);
        }

        // Getting top element and get sqrt of that
        // then add floor value back to heap
        for (int i = 0; i < k; i++) {
            long val = (long) Math.floor(Math.sqrt(pq.poll()));
            pq.add(val);
        }

        // Add all element from pq into res
        while (!pq.isEmpty()) {
            res += pq.poll();
        }

        return res;
    }
}