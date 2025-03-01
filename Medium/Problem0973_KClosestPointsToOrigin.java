package Medium;

import java.util.PriorityQueue;

// Time Complexity: O(n log k)
// Space Complexity: O(k)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Priority Queue with custom comparator (Max heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> squareDist(b) - squareDist(a));

        // Storing elements in pq
        for (int[] point : points) {
            // if size of pq is less than k then add current point in pq
            if (pq.size() < k) {
                pq.add(point);
            } else {
                // else if size is equal to k then check current point's distance
                // is less than pq.peek()'s distance, if true then
                // remove top element from pq and add current point in pq
                if (squareDist(point) < squareDist(pq.peek())) {
                    pq.poll();
                    pq.add(point);
                }
            }
        }

        // Initialize res of size k
        int[][] res = new int[k][2];

        // Getting k elements from pq and storing it into res array
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

    private int squareDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}