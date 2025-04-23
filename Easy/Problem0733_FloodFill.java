package Easy;

import java.util.*;

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
class Solution {
    // dx and dy array to check boundary
    static final int[] dx = { -1, 1, 0, 0 }; // row movement: up, down
    static final int[] dy = { 0, 0, -1, 1 }; // col movement: left, right

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // if new color is same as provided coordinate's color then
        // return same image without making any changes
        if (image[sr][sc] == color) {
            return image;
        }

        int n = image.length, m = image[0].length;
        // queue for BFS
        Deque<int[]> q = new ArrayDeque<>();
        // storing original color in prevColor variable to check later in BFS
        int prevColor = image[sr][sc];

        // adding starting pixels in the queue and updating its color to new color
        q.add(new int[] { sr, sc });
        image[sr][sc] = color;

        // while q is not empty do so
        while (!q.isEmpty()) {
            // get the top element from the q
            int[] top = q.poll();
            // store x and y coordinates in seperate variables
            int x = top[0];
            int y = top[1];

            // check in four directions
            for (int d = 0; d < 4; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                // if newX and newY is within boundary and
                // it is same as prevColor then add it in q and update its color
                if (newX >= 0 && newX < n && newY >= 0 && newY < m
                        && image[newX][newY] == prevColor) {
                    q.add(new int[] { newX, newY });
                    image[newX][newY] = color;
                }
            }
        }

        return image;
    }
}