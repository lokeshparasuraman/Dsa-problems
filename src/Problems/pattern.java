package Problems;

import java.util.Arrays;

public class pattern {
    static void main(String[] args) {
        pattern6(4);

    }

    static void spiral_pattern(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                matrix[top][i] = num++;

            top++;
            for (int i = top; i <= bottom; i++)
                matrix[i][right] = num++;
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    matrix[bottom][i] = num++;


                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    matrix[i][left] = num++;
                left++;
            }

        }
        for (int[] a : matrix) {
            for (int i : a)
                System.out.printf("%3d", i);

            System.out.println();
        }

    }

    static void pattern_traingle(int n) {
        for (int i = 1; i <= n; i++) {
            int c = 2 * n - 1;

            for (int j = 1; j <= c; j++) {
                if (i + j <= n) {
                    System.out.print("  ");
                } else if (j - i >= n) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }

            }
            System.out.println();
        }
    }

    static void zohoPattern(int n) {
        n = 2 * n;
        for (int row = 1; row <= n - 1; row++) {
            for (int col = 1; col <= n - 1; col++) {
                int layer = Math.min(Math.min(row - 1, col - 1), Math.min(n - row - 1, n - col - 1));
                if (layer % 2 == 0) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    static void zoho_pattern1(int n) {
        int on = 2 * n - 1;
        n = 2 * n;
        for (int row = 1; row <= n - 1; row++) {
            for (int col = 1; col <= n - 1; col++) {
                int atEveryIndex = on - Math.min(Math.min(row - 1, col - 1), Math.min(n - row - 1, n - col - 1));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

    static void pattern2(int rows) {
        for (int row = 0; row < rows; row++) {

            for (char ch = 'A'; ch < 'A' + row; ch++) {
                System.out.print(ch + " ");
            }
            for (int j = 0; j < rows - row - 1; j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 0; i < n * 2; i++) {
            int c = i > n ? 2 * n - i : i;
            for (int j = 0; j < c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    static void pattern4(int n) {
        for (int i = 0; i < n * 2; i++) {
            int c = i > n ? 2 * n - i : i;
            int spaces = n - c;
            for (int k = 0; k < spaces; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    static void pattern5(int n) {
        for (int i = 0; i < 2 * n; i++) {

            int c = i > n ? 2 * n - i : i;
            int spaces = n - c;

            System.out.println(" ".repeat(spaces) + "* ".repeat(c));
        }
    }

    static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            int rows = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(rows + " ");
                rows = rows + n - j;
            }
            System.out.println();
        }

    }

    static void pattern7(int n) {
        for (int i = 0; i < n * 2 - 1; i++) {
            int d = Math.abs(n - i - 1);
            int c = d + 1;
            int spaces = n - d;
            System.out.println(" ".repeat(spaces) + "* ".repeat(c));
        }
    }

    static void pattern8(int n) {
        for (int i = 0; i < n * 2; i++) {
            int d = Math.abs(n - i);
            int c = n - d;
            int spaces = d;
            System.out.println(" ".repeat(spaces) + "* ".repeat(c));
        }
    }

    static void pattern9(int n) {
        for (int i = 0; i < (n * 2) - 1; i++) {
            int d = Math.abs((n - 1) - i);
            int inner = (n - d - 1) * 2 - 1;

            System.out.print(" ".repeat(d));
            System.out.print("*");

            if (inner >= 1) {
                System.out.print(" ".repeat(inner));
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern10(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int c = i >= n ? 2 * n - i : i;

            for (int j = 0; j < n - c; j++) {
                System.out.print("  ");
            }
            for (int j = c; j >= 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 2; j <= c; j++) {
                System.out.print(j + " ");

            }
            System.out.println();
        }
    }

    static void snake_pattern(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%4d", num++);
                }
            } else {
                int temp = num + n - 1;
                for (int j = 0; j < n; j++) {
                    System.out.printf("%4d", temp--);
                }
                num += n;
            }
            System.out.println();
        }
    }

    static void diamond_number_pyramid(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int rowValue = i >= n ? 2 * n - i : i;

            for (int j = 1; j <= n - rowValue; j++) {
                System.out.print("  ");
            }
            for (int j = rowValue; j >= 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 2; j <= rowValue; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    static void continue_across_rows(int n) {
        int num = 1;
        for (int i = 1; i <= 2 * n - 1; i++) {

            int rowValue = i <= n ? i : 2 * n - i;
            for (int s = 1; s <= n - rowValue; s++) {
                System.out.print("  ");
            }

            int count = 2 * rowValue - 1;
            for (int j = 1; j <= count; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }

    }
    static void diagonal_pattern(int n){
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j||i+j==n-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

}

