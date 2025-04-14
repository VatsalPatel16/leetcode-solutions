package Medium;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // Queue to add rotten oranges
        Queue<int[]> q = new LinkedList<>();
        int time = 0, freshOranges = 0;

        // Enqueue all rotten oranges and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // while queue is not empty and count of fresh oranges is greater then 0 do so
        while (!q.isEmpty() && freshOranges > 0) {
            int len = q.size();
            // flag rottedThisRound to check if we have rotted any oranges this round
            boolean rottedThisRound = false;

            // check for all rotted oranges enqueued in the queue
            for (int i = 0; i < len; i++) {
                // get the first element from queue
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];

                // Boundary check
                int[] dx = { -1, 1, 0, 0 };
                int[] dy = { 0, 0, -1, 1 };
                for (int d = 0; d < 4; d++) {
                    int newX = x + dx[d];
                    int newY = y + dy[d];

                    // Boundary check and rot logic
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m
                            && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.add(new int[] { newX, newY });
                        freshOranges--;
                        rottedThisRound = true;
                    }
                }

            }
            // if rotted atleast one orange this round then increment time
            if (rottedThisRound) {
                time++;
            }

        }
        // if count of fresh oranges is equal to 0 then return time
        // otherwise return -1
        return freshOranges == 0 ? time : -1;
    }
}