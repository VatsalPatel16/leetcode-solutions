package Easy;

import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(h), where h = height of the tree
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // res list to store output
        List<Integer> res = new ArrayList<>();

        // if root is equal to null return empty res list
        if (root == null) {
            return res;
        }

        // using stack for modified preorder traversal
        Stack<TreeNode> stack = new Stack<>();
        // First push root into stack to start traversal
        stack.push(root);

        // while stack is not empty do so
        while (!stack.isEmpty()) {
            // first get the top element from the stack
            TreeNode top = stack.pop();

            // add its val in res list
            res.add(top.val);

            // then if left of top is not equal to null then push it into stack
            if (top.left != null)
                stack.push(top.left);

            // if right of top is not equal to null then push it into stack
            if (top.right != null)
                stack.push(top.right);
        }

        // to get the postorder traversal reverse the res list
        Collections.reverse(res);
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
