package Problems;

public class maze {
    public static void main(String[] args) {
        boolean[][] arr = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathObstacles("", arr, 0, 0);
       

    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            path(p + 'D', r - 1, c);
        }
        if (c > 1) {
            path(p + 'R', r, c - 1);
        }
    }

    static void pathObstacles(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length-1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1) {
            pathObstacles(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathObstacles(p + 'R', maze, r, c + 1);
        }
    }
}
