package Easy;

import java.util.Collections;
import java.util.PriorityQueue;

// Time Complexity: O(n log n)
// Space Complexity: O(n)
class Solution {
    public int lastStoneWeight(int[] stones) {
        // Use pq to store elements from highest to lowest weight
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Storing stones in pq
        for (int stone : stones) {
            pq.add(stone);
        }

        // while pq's size is greater than one do so
        while (pq.size() > 1) {
            // Getting two largest elements
            int y = pq.poll();
            int x = pq.poll();

            // Checking for condition given in the problem
            if (x == y) {
                continue;
            } else {
                pq.add(y - x);
            }
        }

        // if pq is not empty then get last element from pq otherwise return 0
        return !pq.isEmpty() ? pq.peek() : 0;
    }
}