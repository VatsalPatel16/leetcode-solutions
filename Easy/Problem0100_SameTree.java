package Easy;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if both the trees are null then return true
        if (p == null && q == null) {
            return true;
        }

        // Two queues to traverse both trees p and q
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        // Adding root of p in q1 and root of q in q2
        q1.offer(p);
        q2.offer(q);

        // while both the queues are not empty do so
        while (!(q1.isEmpty() || q2.isEmpty())) {
            // get the first node from q1 into node1
            TreeNode node1 = q1.poll();
            // also do the same for q2
            TreeNode node2 = q2.poll();

            // if both the nodes are null then continue
            if (node1 == null && node2 == null)
                continue;

            // if any of the node is null or values of both nodes are different
            // then in that case return false
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;

            // add left and right subtree of node1 in q1
            q1.offer(node1.left);
            q1.offer(node1.right);
            // and left and right subtree of node2 in q2
            q2.offer(node2.left);
            q2.offer(node2.right);
        }

        // if the traversal in complete that means both the trees are same
        // in that case return true
        return true;

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