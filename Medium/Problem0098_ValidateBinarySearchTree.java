package Medium;

// Time Complexity : O(n)
// Space Complexity : O(h) (where h is the height of the tree)
class Solution {
    public boolean isValidBST(TreeNode root) {
        // calling function checkBST with root
        // and min and max value of long
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode node, long min, long max) {
        // Base case - if node is equal to null return true
        if (node == null) {
            return true;
        }

        // check if current node.val is greater than min and less than max
        // recursive call of checkBST for node.left and node.right
        // update max to node.val for node.left call and
        // update min to node.val for node.right call

        // if all the conditions are true then return true
        // otherwise if any of the condition is false return false
        return (node.val > min && node.val < max &&
                checkBST(node.left, min, node.val) &&
                checkBST(node.right, node.val, max));
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