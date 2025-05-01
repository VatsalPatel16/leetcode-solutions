package Medium;

// Time Complexity: O(n * 32) ≈ O(n), where 32 is the bit-length of integers.
// Space Complexity: O(n * 32) for storing binary representations in the Trie.
class Solution {
    // TrieNode for Trie structure
    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            // it can have two children 0 and 1
            children = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int[][] binaryBits = new int[n][32];
        int maxXor = 0;

        // Converting the numbers given in nums array into binary format
        // and storing that in binaryBits array
        for (int i = 0; i < n; i++) {
            int num = nums[i], pos = 31;
            while (num > 0) {
                binaryBits[i][pos--] = num % 2;
                num /= 2;
            }
        }

        // Initialize root node
        TrieNode root = new TrieNode();
        // Making Trie structure using binaryBits array
        for (int[] binaryNum : binaryBits) {
            TrieNode pointer = root;
            for (int bit : binaryNum) {
                if (pointer.children[bit] == null) {
                    pointer.children[bit] = new TrieNode();
                }
                pointer = pointer.children[bit];
            }
        }

        // Finding Xor for each num and maximize that using complement bit
        // like if current bit is 0 then check if 1 is available then go for 1
        // otherwise go with same bit
        for (int[] binaryNum : binaryBits) {
            TrieNode pointer = root;
            int currXor = 0;
            for (int bit : binaryNum) {
                int oppBit = 1 - bit;

                if (pointer.children[oppBit] != null) {
                    currXor = (currXor << 1) | 1;
                    pointer = pointer.children[oppBit];
                } else {
                    currXor = (currXor << 1) | 0;
                    pointer = pointer.children[bit];
                }
            }
            // Maximize maxXor for output
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}