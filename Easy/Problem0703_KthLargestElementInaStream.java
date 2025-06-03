package Easy;

import java.util.PriorityQueue;
import java.util.Queue;

// Time Complexity of constructor: O(n log k)
// Time Complexity of add method: O(log k)
// Space Complexity: O(k)
class KthLargest {

    Queue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        // Initialize priority queue
        pq = new PriorityQueue<>();
        // giving local k value to instance variable to use in add method
        this.k = k;

        // adding element in pq
        for (int n : nums) {
            pq.add(n);
            // if size of pq is greater than k then poll out element from pq
            if (pq.size() > k)
                pq.poll();
        }
    }

    public int add(int val) {
        // adding val in pq
        pq.add(val);

        // if size of pq is greater than k then remove top element
        if (pq.size() > k)
            pq.poll();

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */