package Oops.graphs;
import java.util.LinkedList;
import java.util.Queue;

/* Le-etCode 994. Rotting Oranges*/
class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            ans = Math.max(ans, t);

            if (r > 0 && grid[r - 1][c] == 1 && !visited[r - 1][c]) {
                q.offer(new int[] { r - 1, c, t + 1 });
                visited[r - 1][c] = true;
            }
            if (r + 1 < m && grid[r + 1][c] == 1 && !visited[r + 1][c]) {
                q.offer(new int[] { r + 1, c, t + 1 });
                visited[r + 1][c] = true;
            }
            if (c > 0 && grid[r][c - 1] == 1 && !visited[r][c - 1]) {
                q.offer(new int[] { r, c - 1, t + 1 });
                visited[r][c - 1] = true;
            }
            if (c + 1 < n && grid[r][c + 1] == 1 && !visited[r][c + 1]) {
                q.offer(new int[] { r, c + 1, t + 1 });
                visited[r][c + 1] = true;
            }
        }
//check for unrotten oranges//
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) 
                    return -1;
                
            }
        }
        return ans;
    }
}