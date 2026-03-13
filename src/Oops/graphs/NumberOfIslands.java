package Oops.graphs;

public class NumberOfIslands {
    static void main() {

    }

    private static final int[][] dir = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1' && !visited[i][j])
                {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        visited[i][j] = true;

        for (int[] d : dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && grid[nexti][nextj] == '1'
                    && !visited[nexti][nextj]) {
                dfs(nexti, nextj, grid, visited);
            }
        }
    }
}

