package Problems;

import java.util.Arrays;

//498.Diagonal Traverse
public class DiagonalMatrix {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;

        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];

            if ((row + col) % 2 == 0) {
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else { row--; col++; }
            } else {
                if (row == m - 1) col++;
                else if (col == 0) row++;
                else { row++; col--; }
            }
        }

        return result;
    }

    static void main() {
        int[][]m={
                {3,7,1,4},
                {7,0,9,2},
                {5,1,7,0},
                {9,7,2,8}
        };
        System.out.println(Arrays.toString(findDiagonalOrder(m)));
    }
}