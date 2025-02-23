package Medium;

// Time Complexity : O(n)
// Space Complexity : O(1) (Because used Morris Traversal)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // curr pointer pointing to root of the tree
        TreeNode curr = root;

        // while curr is not equal to null do so
        while (curr != null) {
            // if curr.left is equal to null then decrement k
            // check if k == 0, if true then return curr.val
            // update curr = curr.right
            if (curr.left == null) {
                k--;
                if (k == 0) {
                    return curr.val;
                }
                curr = curr.right;
            }
            // if curr.left is not equal to null do this
            else {
                // pointer prev to find inorder predecessor of curr
                TreeNode prev = curr.left;
                // finding inorder predecessor
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // if prev.right is equal to null
                // then connect prev.right to curr(temp link)
                // update curr to curr.left
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                // disconnect the link of prev and curr
                // decrement k and check if k == 0, if true then return curr.val
                else {
                    prev.right = null;
                    k--;
                    if (k == 0) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        // if not found Kth smallest then return -1
        return -1;
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