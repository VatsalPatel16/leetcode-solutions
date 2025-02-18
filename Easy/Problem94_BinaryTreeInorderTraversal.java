package Easy;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // res list to store output
        List<Integer> res = new ArrayList<>();

        // Initialize curr as root (pointer)
        TreeNode curr = root;
        // while curr is not equal to null do so
        while (curr != null) {
            // if curr does not have left child then visit the node, add its val to
            // res and go to its right
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                // otherwise find its inorder predecessor
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // make curr, right child of its inorder predecessor (temporary link)
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                // Revert back all the changes made in the tree structure
                else {
                    prev.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
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