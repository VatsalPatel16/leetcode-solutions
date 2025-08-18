package Easy;

import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // res to store output
        List<Integer> res = new ArrayList<>();

        // if root is equal to null return empty res list
        if (root == null)
            return res;

        // using stack for preorder traversal
        Stack<TreeNode> stack = new Stack<>();
        // First push root into stack to start traversal
        stack.push(root);

        // while stack is not empty do so
        while (!stack.isEmpty()) {
            // first get the top element from the stack
            TreeNode top = stack.pop();
            // add its value in res list as
            // preorder traversal is root -> left -> right
            res.add(top.val);

            // if right of top is not equal to null push it into stack
            if (top.right != null)
                stack.push(top.right);

            // same if left of the top is not equal to null push it into stack
            if (top.left != null)
                stack.push(top.left);
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
