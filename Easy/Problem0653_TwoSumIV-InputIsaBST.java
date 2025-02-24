package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // set to store elements of tree
        Set<Integer> set = new HashSet<>();
        // curr pointer pointing to root of the tree
        TreeNode curr = root;

        // while curr is not equal to null do so
        while (curr != null) {
            // if curr.left is equal to null check
            // if set contains (k - curr.val) then return true
            if (curr.left == null) {
                if (set.contains(k - curr.val)) {
                    return true;
                }
                // add current element in set
                set.add(curr.val);
                // update curr to curr.right
                curr = curr.right;
            }
            // otherwise do this
            else {
                // prev pointer to find inorder predecessor of curr
                TreeNode prev = curr.left;
                // Finding inorder predecessor
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // if prev.right is equal to null
                // connect prev.right and curr (temp link)
                // update curr to curr.left
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                // else disconnect the link and check for k - curr.val
                // in set
                else {
                    prev.right = null;
                    if (set.contains(k - curr.val)) {
                        return true;
                    }
                    set.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        // return false if not found pair sum in BST
        return false;
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