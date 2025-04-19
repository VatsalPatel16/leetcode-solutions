package Easy;

import java.util.*;

// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Initialize adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // queue for BFS
        Deque<Integer> q = new ArrayDeque<>();
        // visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Building adj list using edges array
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Starting BFS from source node
        q.add(source);
        // and marking as visited
        visited[source] = true;
        // BFS traversal
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjNode : adj.get(node)) {
                if (!visited[adjNode]) {
                    q.add(adjNode);
                    visited[adjNode] = true;
                }
            }
        }

        // if destination node is visited then path exist
        // and if not then path doesn't exist
        return visited[destination];
    }
}