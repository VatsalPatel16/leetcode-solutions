package Medium;

import java.util.*;

// Time Complexity: O((V + E) * log V)
// Space Complexity: O(V + E)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // nodeA -> [nodeB, weight] adj list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        // minTime to store min time to reach to nodes from node k
        int[] minTime = new int[n];
        // visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        // [time, node] min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Building adj list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0] - 1).add(new int[] { time[1] - 1, time[2] });
        }

        // filling minTime array with max value of int
        Arrays.fill(minTime, Integer.MAX_VALUE);
        // and minTime[k - 1] will be 0
        minTime[k - 1] = 0;

        // Adding node k - 1 in pq
        pq.add(new int[] { 0, k - 1 });

        // While pq is not empty do so
        while (!pq.isEmpty()) {
            // Get the top element from pq
            int[] top = pq.poll();
            // storing time and node in different variables
            int time = top[0];
            int node = top[1];

            // if already visited node then continue
            if (visited[node])
                continue;

            // otherwise mark node as visited
            visited[node] = true;

            // for all its unvisited adj nodes
            for (int[] adjNode : adj.get(node)) {
                int neighbour = adjNode[0];
                int weight = adjNode[1];

                // check if neighbour is not visited and current (time + weight)
                // is less then minTime[neighbour]
                // if yes then update minTime[neighbour] and add it in pq
                if (!visited[neighbour] && time + weight < minTime[neighbour]) {
                    minTime[neighbour] = time + weight;
                    pq.add(new int[] { minTime[neighbour], neighbour });
                }
            }
        }

        // get the max value from minTime array and that will be our answer
        int maxTime = 0;
        for (int t : minTime) {
            // if any of the value in minTime array is max value of int then return -1
            if (t == Integer.MAX_VALUE)
                return -1;

            maxTime = Math.max(maxTime, t);
        }

        return maxTime;
    }
}