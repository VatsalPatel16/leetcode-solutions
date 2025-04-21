package Medium;

import java.util.PriorityQueue;

// Time Complexity: O(n^2 * log n)
// Space Complexity: O(n^2)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // Min heap with [cost, point]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // visited array to keep track of visited points
        boolean[] visited = new boolean[n];
        // totalCost to keep track of final result
        // and visitedCount to track count of visited points
        int totalCost = 0, visitedCount = 0;

        // adding first point in the pq with cost 0
        pq.add(new int[] { 0, 0 });

        // while pq is not empty and visitedCount is less than n do so
        while (!pq.isEmpty() && visitedCount < n) {
            // get the first element from pq
            int[] top = pq.poll();
            // put cost and point in seperate variables
            int cost = top[0];
            int point = top[1];

            // if current point is already visited then continue
            if (visited[point])
                continue;

            // otherwise mark current point as visited
            visited[point] = true;
            // increment visitedCount and update totalCost by adding current cost
            visitedCount++;
            totalCost += cost;

            // Iterate over each points
            for (int i = 0; i < n; i++) {
                // if point is not visited then calculate its manhattan distance
                // from current point and add it in pq
                if (!visited[i]) {
                    int dist = Math.abs(points[point][0] - points[i][0]) +
                            Math.abs(points[point][1] - points[i][1]);

                    pq.add(new int[] { dist, i });
                }
            }
        }

        return totalCost;
    }
}