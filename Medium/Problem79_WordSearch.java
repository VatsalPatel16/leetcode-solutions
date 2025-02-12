package Medium;

// Time Complexity: O(m * n * 4^k)
// Space Complexity: O(k) (due to recursion stack)
class Solution {
    public boolean exist(char[][] board, String word) {
        // finding first char from word in board matrix to start search
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if found then also check for other characters in array
                // and if found then return true
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        // if not found word in board return false
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // if index is equal to length of string word return true
        // found string word in board
        if (index == word.length()) {
            return true;
        }

        // if search goes out of bound then return false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Storing current char in temp for backtrack
        char temp = board[i][j];
        // marking current position as visited so that we don't go there
        board[i][j] = '1';
        // Searching all the adjacent cells
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        // backtrack step
        board[i][j] = temp;

        return found;
    }
}