package Medium;

import java.util.*;

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
class Solution {
    // dx and dy array to check for the boundary
    static final int[] dx = { -1, 1, 0, 0 }; // row movement: up, down
    static final int[] dy = { 0, 0, -1, 1 }; // col movement: left, right

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        // visited array to keep track of visited lands
        boolean[][] visited = new boolean[n][m];
        // Using queue for BFS
        Deque<int[]> q = new ArrayDeque<>();
        // count will store number of islands
        int count = 0;

        // for each row
        for (int i = 0; i < n; i++) {
            // Iterate over each cell
            for (int j = 0; j < m; j++) {
                // if found land and if it is unvisited
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // then increment island count
                    count++;
                    // mark that as visited
                    visited[i][j] = true;
                    // and add it into queue to find the whole island using BFS
                    q.add(new int[] { i, j });

                    // while queue is not empty do so
                    while (!q.isEmpty()) {
                        // get the first element
                        int[] pos = q.poll();
                        // check in all 4 directions
                        for (int d = 0; d < 4; d++) {
                            int newX = pos[0] + dx[d];
                            int newY = pos[1] + dy[d];
                            // if found land which is unvisited
                            // then mark it as visited and add it to queue
                            if (newX >= 0 && newX < n && newY >= 0 && newY < m &&
                                    grid[newX][newY] == '1' && !visited[newX][newY]) {
                                visited[newX][newY] = true;
                                q.add(new int[] { newX, newY });
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}