package Oops.graphs;

import java.util.*;
import java.util.HashSet;

class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println(NoOfIslands(grid));
    }

    private final static int[][] dir = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public static int NoOfIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashSet<List<String>> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> v = new ArrayList<>();
                    dfs(i, j, i, j, v, grid, visited);
                    set.add(v);
                }
            }
        }
        return set.size();
    }

    public static void dfs(int i, int j, int si, int sj, List<String> v, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        v.add((i - si) + "," + (j - sj));

        for (int[] d : dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && grid[nexti][nextj] == 1 && !visited[nexti][nextj]) {
                dfs(nexti, nextj, si, sj, v, grid, visited);
            }
        }
    }
}

