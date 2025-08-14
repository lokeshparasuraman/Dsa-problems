//1559.find cycle in a 2d grid Use recursion and dfs //
class findCycleIn2DGriduingAdjMatrix {
    private int m;
    private int n;
    private char[][] grid;
    private final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int j, int previ, int prevj, char curr) {
        visited[i][j] = true;
        // check for all directions on a char for cycle detection//
        for (int[] d : dirs) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti < 0 || nexti >= m || nextj < 0 || nextj >= n)
                continue;
            if (grid[nexti][nextj] != curr)
                continue;
            if (!visited[nexti][nextj]) {
                if (dfs(nexti, nextj, i, j, curr)) {
                    return true;
                }
            } else if (nexti != previ || nextj != prevj) {
                return true;
            }
        }
        return false;
    }
}