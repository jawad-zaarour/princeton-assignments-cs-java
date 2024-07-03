/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;

        long[][] T = new long[n + 1][n + 1];
        T[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    T[i][j] = T[i - 1][j] + 2 * T[i - 1][j + 1];
                }
                else if (j == i) {
                    T[i][j] = T[i - 1][j - 1];
                }
                else {
                    T[i][j] = T[i - 1][j - 1] + T[i - 1][j] + T[i - 1][j + 1];
                }
            }
        }

        if (k < 0) return T[n][Math.abs(k)];
        return T[n][k];
    }
}
