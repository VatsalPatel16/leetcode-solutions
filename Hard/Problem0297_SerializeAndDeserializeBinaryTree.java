package Hard;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // StringBuilder to store result
        StringBuilder res = new StringBuilder();
        // using helper function to get preorder traversal of the tree
        preorderSerialize(root, res);
        // return res as a string
        return res.toString();
    }

    // helper function to serialize
    private void preorderSerialize(TreeNode node, StringBuilder res) {
        // Base case - if node is equal to null append "N," to res and return
        if (node == null) {
            res.append("N,");
            return;
        }
        // append current val + "," to res
        res.append(node.val + ",");

        // Recursive call for node.left and node.right
        preorderSerialize(node.left, res);
        preorderSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Spliting nodes from the data and storing them in String array
        String[] nodes = data.split(",");
        // i is a pointer to traverse through nodes array
        int[] i = { 0 };
        // calling helper function to deserialize data String
        return preorderDeSerialize(i, nodes);
    }

    // helper function to deserialize
    private TreeNode preorderDeSerialize(int[] i, String[] nodes) {
        // if i is greater than or equal to length of nodes array or
        // value in nodes array is "N" then increment i and return null
        if (i[0] >= nodes.length || nodes[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        // Creating node with current value
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i[0]]));
        // increment i pointer
        i[0]++;

        // Recursive call for node.left and node.right
        node.left = preorderDeSerialize(i, nodes);
        node.right = preorderDeSerialize(i, nodes);

        return node;
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

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));