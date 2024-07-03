/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][n];
        int maxSize = 0;

        // Fill the dp table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = a[i][j];
                }
                else if (a[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                else {
                    dp[i][j] = 0;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input and prints the size of the largest contiguous square submatrix containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        while (!StdIn.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }

        StdOut.println(size(a));
    }
}
