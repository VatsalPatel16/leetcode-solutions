package Easy;

import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int thirdMax(int[] nums) {
        // Min heap
        Queue<Integer> pq = new PriorityQueue<>();
        // Set to store only distinct elements in the pq
        Set<Integer> set = new HashSet<>();

        // Iterate over nums array
        for (int n : nums) {
            // if n is not already in the set then do so
            if (set.add(n)) {
                // first if size of pq is less than 3 then
                // add n in pq
                if (pq.size() < 3) {
                    pq.add(n);
                }
                // otherwise if n is greater than top element of pq
                // then first poll out top element and add current n in pq
                else if (n > pq.peek()) {
                    pq.poll();
                    pq.add(n);
                }
            }
        }

        // if size of pq is less than 3 then return max number
        if (pq.size() < 3) {
            while (pq.size() != 1) {
                pq.poll();
            }
            return pq.poll();
        }
        // otherwise return third max number
        else {
            return pq.poll();
        }
    }
}