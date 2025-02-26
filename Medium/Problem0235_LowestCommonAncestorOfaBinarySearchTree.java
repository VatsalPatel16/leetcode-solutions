package Medium;

// Time Complexity: O(log n)
// Space Complexity: O(h) (where, h is the height of the tree)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case - if root is equal to null return null
        if (root == null)
            return null;

        // if any of p or q is equal to root then root itself is LCA
        // So return root
        if (p == root || q == root)
            return root;

        // if both p and q less than root then go to root.left
        // Recursive call
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // if both p and q greater than root then go to root.right
        // Recursive call
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // if one on the left and another on the right then root is LCA
        return root;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}