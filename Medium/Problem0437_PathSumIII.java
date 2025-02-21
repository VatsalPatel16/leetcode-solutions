package Medium;

import java.util.Map;
import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    // map to store sum and its count in the function dfs
    Map<Long, Integer> map = new HashMap<>();
    // res to store output
    int res = 0;
    // currSum to keep track of prefix sum in recursive function dfs
    long currSum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // put (0, 1) in the map
        map.put(0L, 1);
        // call function dfs with root and targetSum
        dfs(root, targetSum);

        return res;
    }

    private void dfs(TreeNode node, int targetSum) {
        // if node is equal to null return
        if (node == null) {
            return;
        }
        // add current node.val in currSum
        currSum += node.val;
        // if map containsKey (currSum - targetSum) then get its value from map and
        // add it to res
        if (map.containsKey(currSum - targetSum)) {
            res += map.get(currSum - targetSum);
        }
        // put currSum in map
        // and if already exist then increment its count
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // recursive call for node.left and node.right
        dfs(node.left, targetSum);
        dfs(node.right, targetSum);

        // Backtrack step
        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
        currSum -= node.val;
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