package Hard;

// Time Complexity: O(n)
// Space Complexity: O(h), where h is the height of the tree.
class Solution {
    // res to store output
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // Calling dfs function for the given root
        dfs(root);

        return res;
    }

    private int dfs(TreeNode node) {
        // Base case - if node is equal to null return 0
        if (node == null) {
            return 0;
        }

        // Recursive call for node.left and ignoring negative contributions
        int left = Math.max(0, dfs(node.left));
        // Recursive call for node.right and ignoring negative contributions
        int right = Math.max(0, dfs(node.right));

        // Maximize result b/w current res & (left + node.val + right)
        res = Math.max(res, (left + node.val + right));
        // return node.val + max of left and right
        return node.val + Math.max(left, right);
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