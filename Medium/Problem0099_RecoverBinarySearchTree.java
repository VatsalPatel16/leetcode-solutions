package Medium;

// Time Complexity: O(n)
// Space Complexity: O(h) (where, h is the height of the tree)
class Solution {
    public void recoverTree(TreeNode root) {
        // Initializing pointer to fix the BST
        TreeNode first[] = { null }, middle[] = { null }, last[] = { null }, prev[] = { null };

        // calling fixBST function
        fixBST(root, first, middle, last, prev);

        // Correcting the BST by swaping values of two nodes
        // which are swapped by mistake
        if (first[0] != null && last[0] != null) {
            swap(first[0], last[0]);
        } else if (first[0] != null && middle[0] != null) {
            swap(first[0], middle[0]);
        }
    }

    private void fixBST(TreeNode node, TreeNode[] first, TreeNode[] middle,
            TreeNode[] last, TreeNode[] prev) {
        // Base case - if node is equal to null return
        if (node == null)
            return;
        // Recursive call for node.left
        fixBST(node.left, first, middle, last, prev);

        // if this node is smaller than prev node then violation of BST rule
        if (prev[0] != null && node.val < prev[0].val) {
            // if it is first violation
            // mark these two nodes as first and middle
            if (first[0] == null) {
                first[0] = prev[0];
                middle[0] = node;
            }
            // if second violation mark this node as last
            else {
                last[0] = node;
            }
        }
        // mark this node as prev
        prev[0] = node;
        // Recursive call for node.right
        fixBST(node.right, first, middle, last, prev);
    }

    // Swapping values of two nodes
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
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