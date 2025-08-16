package Oops.graphs;
import java.util.*;
class Pair {
    int x;
    int y;
    int dist;

    // Constructor to initialize the pair
    public Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class NearestZero {
    public static int[][] nearestZero(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        // Initialize the queue with zero locations
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // BFS to find the nearest zero
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.x;
            int c = p.y;
            int d = p.dist;
            ans[r][c] = d;

            if (r > 0 && !visited[r-1][c]) {
                q.add(new Pair(r-1, c, d+1));
                visited[r-1][c] = true;
            }
            if (r+1 < m && !visited[r+1][c]) {
                q.add(new Pair(r+1, c, d+1));
                visited[r+1][c] = true;
            }
            if (c > 0 && !visited[r][c-1]) {
                q.add(new Pair(r, c-1, d+1));
                visited[r][c-1] = true;
            }
            if (c+1 < n && !visited[r][c+1]) {
                q.add(new Pair(r, c+1, d+1));
                visited[r][c+1] = true;
            }
        }

        return ans;
    }

        public static int[][] nearestZero2(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] ans = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> q = new LinkedList<>();

            // Single 2D direction array for up, right, down, left
            int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            // Initialize the queue with zero locations
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        q.offer(new int[]{i, j, 0}); // [row, col, distance]
                        visited[i][j] = true;
                    }
                }
            }

            // BFS to find the nearest zero
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int d = curr[2];
                ans[r][c] = d;

                // Check all four directions using the single direction array
                for (int[]arr:dir) {
                    int nr = r + arr[0];
                    int nc = c + arr[1];

                    // Check if the new position is valid and not visited
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        q.add(new int[]{nr, nc, d + 1});
                        visited[nr][nc] = true;
                    }
                }
            }

            return ans;
        }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }


        int[][] ans = nearestZero(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

}