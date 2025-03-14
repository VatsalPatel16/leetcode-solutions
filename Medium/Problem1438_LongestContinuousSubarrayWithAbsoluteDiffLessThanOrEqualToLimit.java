package Medium;

import java.util.ArrayDeque;
import java.util.Deque;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Using two Deques
        // minQueue - Monotonic increasing queue
        // maxQueue - Monotonic decreasing queue
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        // two pointers l & r and res to store output
        int n = nums.length, l = 0, r = 0, res = 0;

        // while r is less than length of nums do so
        while (r < n) {
            // while minQueue is not empty and element at tail of the queue is
            // greater than element at pointer r, remove element from tail
            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[r]) {
                minQueue.pollLast();
            }
            // while maxQueue is not empty and element at tail of the queue is
            // less than element at pointer r, remove element from tail
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[r]) {
                maxQueue.pollLast();
            }

            // add r in both minQueue and maxQueue
            minQueue.add(r);
            maxQueue.add(r);

            // while difference is greater than limit remove element from
            // head of the both queues and increment l pointer
            while (nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit) {
                if (l == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }
                if (l == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }
                l++;
            }

            // Maximize the res
            res = Math.max(res, (r - l + 1));
            // increment r pointer at each iteration
            r++;
        }

        return res;
    }
}
