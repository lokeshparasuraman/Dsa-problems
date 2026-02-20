package Problems;
public class pattern {
    public static void main(String[] args) {
        pattern6(5);
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
    static void pattern1(int n) {
        int on = n;
        n = 2 * n;
        for (int row = 1; row <= n - 1; row++) {
            for (int col = 1; col <= n - 1; col++) {
                int atEveryIndex = on - Math.min(Math.min(row - 1, col - 1), Math.min(n - row - 1, n - col - 1));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
    static void pattern_star(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print("* ");

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

            System.out.println(" ".repeat(spaces)+"* ".repeat(c));
        }
    }

    static void pattern6(int n) {
        for (int i = 1; i <=n; i++) {
            int rows=i;
            for (int j = 1; j <=i; j++) {
                System.out.print(rows+" ");
                rows=rows+n-j;
            }
            System.out.println();
        }

    }


}

