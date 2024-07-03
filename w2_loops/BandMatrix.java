/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     08/05/2024
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Math.abs(i - j) > width) {
                    StdOut.print("0");
                }
                else {
                    StdOut.print("*");
                }
                if (j < n) System.out.print("  ");
            }
            StdOut.println();
        }
    }
}
