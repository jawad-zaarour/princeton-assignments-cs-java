/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     14/02/1993
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {

        // Parse m
        int m = Integer.parseInt(args[0]);

        // Parse array a
        int[] a = new int[args.length - 1];
        int totalSum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
            totalSum += a[i];
        }

        // Calculate cumulative sums
        int[] cumulativeSums = new int[a.length];
        cumulativeSums[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            cumulativeSums[i] = cumulativeSums[i - 1] + a[i];
        }

        // Generate random indices
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * totalSum);
            int low = 0;
            int high = cumulativeSums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (cumulativeSums[mid] <= r) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            System.out.print((low + 1) + " ");
        }
        System.out.println();
    }
}

