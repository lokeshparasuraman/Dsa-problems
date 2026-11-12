package Problems;

import java.io.*;
import java.util.*;
//Maximum sum subarray Less than K
public class maximumSumSubarrayLessthanK {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                String[] arr = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(arr[j]);
                }
            }
            int k = Integer.parseInt(br.readLine());
            System.out.println(maxSumSubmatrix(matrix, k));
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    private static int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int left = 0; left < n; left++) {
            int[] rowSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][right];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int currSum = 0;
                for (int num : rowSum) {
                    currSum += num;
                    Integer target = set.ceiling(currSum - k);
                    if (target != null) {
                        max = Math.max(max, currSum - target);
                    }
                    set.add(currSum);
                }

            }
        }
        return max;
    }

}
