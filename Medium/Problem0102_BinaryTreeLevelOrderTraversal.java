package Medium;

import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize result list to store output
        // and queue for BFS
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        // Adding root of tree in the queue
        q.add(root);

        // Iterate till queue is not empty
        while (!q.isEmpty()) {
            // Initialize list to store value of level nodes
            List<Integer> level = new ArrayList<>();

            // Adding it into list
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                // if node is not equal to null then add its val to list
                // and also add node's left and right in the queue
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }

            // after that adding it into res list
            if (level.size() > 0)
                res.add(level);
        }
        return res;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}