/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     21/4/2024
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {

        // sequence of n integers are between 1 and m
        int m = Integer.parseInt(args[0]);

        // frequencies[i] = # times integer 'i' appears
        int[] frequencies = new int[m + 1];

        // Read integers from standard input
        int total = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            frequencies[x]++;
            total++;

        }

        // compute Shannon entropy
        double entropy = 0.0;
        for (int i = 1; i <= m; i++) {
            if (frequencies[i] > 0) {
                double p = 1.0 * frequencies[i] / total;
                entropy -= p * Math.log(p) / Math.log(2);
            }
        }

        StdOut.printf("%.4f", entropy);
    }
}
