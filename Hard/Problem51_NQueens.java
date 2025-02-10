package Hard;

import java.util.*;

// Time Complexity: O(n!)
// Space Complexity: O(n^2)
class Solution {
    // HashSet col, posDiag and negDiag to keep track of places where we can't put
    // queens
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    // res list to store output
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // board of size n * n
        char[][] board = new char[n][n];

        // Filling board with (.) dots
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Calling backtrack function
        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int r, int n, char[][] board) {
        // Base case - if r is equal to n then make copy ArrayList with each rows
        // and add it into res list
        if (r == n) {
            List<String> copy = new ArrayList<>();

            for (char[] row : board) {
                copy.add(new String(row));
            }

            res.add(copy);
            return;
        }

        // Checking each column in each row
        for (int c = 0; c < n; c++) {
            // if set col contains current c and posDiag contains (r + c)
            // and negDiag contains (r - c) that means we can't put queen in that place
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }

            // if not then update set col, posDiag and negDiag
            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            // also place 'Q' in position board[r][c]
            board[r][c] = 'Q';

            // recursive call of backtrack function with r + 1
            backtrack(r + 1, n, board);

            // undo all the steps (backtracking)
            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}