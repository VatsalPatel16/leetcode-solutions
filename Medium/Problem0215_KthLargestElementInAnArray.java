package Medium;

import java.util.PriorityQueue;
import java.util.Queue;

// Time Complexity: O(n log k)
// Space Complexity: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Initialize Priority Queue to store elements
        Queue<Integer> pq = new PriorityQueue<>();

        // Iterate from first element to last element
        for (int i = 0; i < nums.length; i++) {
            // if size of pq is equal to k then check for given condition
            if (pq.size() == k) {
                // if current element is greater than top element of pq
                // Then remove top element and add current
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            // Otherwise add element to pq
            else {
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}