package Easy;

import java.util.*;

// Time Complexity: O(n log k + k log k)
// Space Complexity: O(k)
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // if k is equal to length of nums then return nums
        if (k == nums.length) {
            return nums;
        }

        // res array to store output
        int[] res = new int[k];

        // Priority Queue with (value, index)
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Iterate over nums array
        for (int i = 0; i < nums.length; i++) {
            // if size of pq is equal to k and
            // current element is greater then top element of pq
            // then poll out top element and add current element
            if (pq.size() == k) {
                if (nums[i] > pq.peek()[0]) {
                    pq.poll();
                    pq.add(new int[] { nums[i], i });
                }
            }
            // otherwise add current element in the pq
            else {
                pq.add(new int[] { nums[i], i });
            }
        }

        // List to store element from pq and sort it according to given index
        List<int[]> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        list.sort((a, b) -> Integer.compare(a[1], b[1]));

        // Store elements from list in res array
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }

        return res;

    }
}