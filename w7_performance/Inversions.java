/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[] array = generate(n, k);
        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i] + " ");
        }


    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }

        int j = 0;
        while (k > 0) {
            for (int i = n - 1; i > j && k > 0; i--, k--) {
                swap(permutation, i, i - 1);
                if (i - 1 == -1) break;
            }
            j++;
        }

        return permutation;
    }

    public static void swap(int[] array, int p, int k) {
        if (isOutOfRange(array, p, k)) {
            return;
        }

        int temp = array[p];
        array[p] = array[k];
        array[k] = temp;
    }

    private static boolean isOutOfRange(int[] array, int p, int k) {
        return p < 0 || p >= array.length || k < 0 || k >= array.length;
    }

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i < j && a[i] > a[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }
}
