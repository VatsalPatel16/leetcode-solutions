package Medium;

import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    // Global variable preIndex to keep track of index in preorder array
    int preIndex = 0;
    // HashMap to store value from inorder array and its indices
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Putting value in the map from inorder array
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // Calling dfs function which will recursively construct binary tree
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        // Base case - if left and right cross each other return null
        if (left > right) {
            return null;
        }

        // Getting current root value
        int rootVal = preorder[preIndex++];
        // Creating new node using rootVal
        TreeNode root = new TreeNode(rootVal);
        // Find index of rootVal from map
        int mid = map.get(rootVal);

        // Recursive call of dfs for root.left and root.right
        root.left = dfs(preorder, left, mid - 1);
        root.right = dfs(preorder, mid + 1, right);

        return root;
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
