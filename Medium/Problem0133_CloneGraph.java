package Medium;

import java.util.*;

// Time Complexity: O(V + E), Where V is the number of nodes and E is the number of edges in the graph
// Space Complexity: O(V), For the visited map and BFS queue
class Solution {
    public Node cloneGraph(Node node) {
        // if given node is null in that case return null
        if (node == null)
            return null;

        // queue for BFS
        Deque<Node> q = new ArrayDeque<>();
        // visited map to keep track of (original node -> clone node)
        Map<Node, Node> visited = new HashMap<>();

        // cloning the given node
        Node clone = new Node(node.val);
        // adding it into visited map and also adding it in queue for BFS
        visited.put(node, clone);
        q.add(node);

        // while queue is not empty do so
        while (!q.isEmpty()) {
            // get the top element from q
            Node top = q.poll();

            // for all neighbors of top
            for (Node n : top.neighbors) {
                // if neighbor node is not in visited map
                if (!visited.containsKey(n)) {
                    // then make clone of that and add it in visited map
                    Node cloneNode = new Node(n.val);
                    visited.put(n, cloneNode);
                    // also add it in q to explore further
                    q.add(n);
                }
                // making neighbor link for cloned node
                visited.get(top).neighbors.add(visited.get(n));
            }
        }

        return visited.get(node);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}