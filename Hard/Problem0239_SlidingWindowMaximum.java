package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // l and r pointer
        int n = nums.length, l = 0, r = 0;
        // res array to store output
        int[] res = new int[n - k + 1];
        // Deque which will be monotonic decreasing queue
        Deque<Integer> dq = new ArrayDeque<>();

        // while r pointer is less than n do so
        while (r < n) {
            // while dq is not empty and element from last of the deque
            // is less than element at pointer r remove element from the last of dq
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            // add r in the dq from last
            dq.offer(r);

            // if l is greater than first of the dq remove element
            // from the head of the dq
            if (l > dq.peekFirst()) {
                dq.pollFirst();
            }

            // if window size is equal to k then add element in res
            // from the head of the dq and increment l pointer
            if ((r + 1) >= k) {
                res[l] = nums[dq.peekFirst()];
                l++;
            }
            // increment r pointer at each iteration
            r++;
        }

        return res;
    }
}