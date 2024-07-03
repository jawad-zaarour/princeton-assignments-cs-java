/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialBrute {

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // Base case: T(0, 0) = 1
        if (n == 0 && k == 0) return 1;

        // Out of bounds cases: T(n, k) = 0
        if (k < -n || k > n) return 0;

        // General case: T(n, k) = T(n-1, k-1) + T(n-1, k) + T(n-1, k+1)
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }
}
