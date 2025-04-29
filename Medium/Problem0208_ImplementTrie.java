package Medium;

// Time Complexity: O(L) per operation (insert/search/startsWith), where L is the length of the word/prefix.
// Space Complexity: O(N * L)
// where N is the number of words inserted and L is the average length, considering storage of each character node.
class Trie {
    // TrieNode class for Trie structure
    // it will keep track of current node's children and end of word
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    // Initializing root node
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        // pointer to traverse Trie structure
        TrieNode pointer = root;

        for (char c : word.toCharArray()) {
            // if current char is not available then add it in structure
            if (pointer.children[c - 'a'] == null) {
                pointer.children[c - 'a'] = new TrieNode();
            }
            // update pointer
            pointer = pointer.children[c - 'a'];
        }
        // at last mark it as end of word
        pointer.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        // pointer to traverse Trie structure
        TrieNode pointer = root;

        for (char c : word.toCharArray()) {
            // if char not found in the structure then word doesn't exist in Trie
            // in that case return false
            if (pointer.children[c - 'a'] == null) {
                return false;
            }
            // update pointer
            pointer = pointer.children[c - 'a'];
        }
        // if it is end of word then it will return true otherwise false
        return pointer.isEndOfWord;
    }

    // Check if a prefix exists in the Trie
    public boolean startsWith(String prefix) {
        // pointer to traverse Trie structure
        TrieNode pointer = root;

        for (char c : prefix.toCharArray()) {
            // if char doesn't exist in that case return false prefix doesn't exist
            if (pointer.children[c - 'a'] == null) {
                return false;
            }
            // update pointer
            pointer = pointer.children[c - 'a'];
        }
        // if found then return true
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */