package Oops.graphs;
import java.util.Arrays;
class O_within_xBoundary {
    private static final int[][] dir = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    static char[][] conquer(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int j = 0; j <n; j++) {
            if (grid[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, grid, visited);
            }
            if (grid[m-1][j] == 'O' && !visited[m-1][j]) {
                dfs(m-1, j, grid, visited);
            }
        }

        for (int i = 1; i < m-1; i++) {
            if (grid[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, grid, visited);
            }
            if (grid[i][n-1] == 'O' && !visited[i][n-1]) {
                dfs(i, n-1, grid, visited);
            }
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 'O' && !visited[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }
        return grid;
    }

    public static void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        for (int[] d : dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nextj >= 0 && nextj < n && nexti >= 0 && nexti < m && !visited[nexti][nextj] && grid[nexti][nextj] == 'O') {
                dfs(nexti, nextj, grid, visited);
            }
        }
    }

    static void main(String[] args) {
        char[][] grid = {
                {'O', 'X', 'X','O'},
                {'O', 'O', 'O','X'},
                {'O', 'X', 'X','O'}
        };
        System.out.println(Arrays.deepToString(conquer(grid)));
    }
}
