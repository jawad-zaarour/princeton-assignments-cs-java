/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

/**
 * The Ramanujan class provides a method to determine whether a given number
 * is a Ramanujan number. A Ramanujan number is an integer that can be expressed
 * as the sum of two positive cubes in two different ways.
 */
public class Ramanujan {

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        int limit = (int) Math.cbrt(n);

        // Check pairs (a, b) and (c, d) such that a^3 + b^3 == n and c^3 + d^3 == n
        for (long a = 1; a <= limit; a++) {
            long a3 = a * a * a;
            long b = (long) Math.cbrt(n - a3); // cbrt: the cube root

            if (b > 0 && a3 + (b * b * b) == n) {
                count++;
                if (count == 2) return true;
            }
        }
        return false;
    }
}
