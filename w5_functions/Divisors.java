/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;

        return Math.abs(a / gcd(a, b) * b); // To avoid overflow, divide before multiply
    }

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) return 0;

        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (areRelativelyPrime(i, n)) count++;
        }
        return count;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
        StdOut.printf("lcm(%d, %d) = %d\n", a, b, lcm(a, b));
        StdOut.printf("areRelativelyPrime(%d, %d) = %s\n", a, b, areRelativelyPrime(a, b));
        StdOut.printf("totient(%d) = %d\n", a, totient(a));
        StdOut.printf("totient(%d) = %d\n", b, totient(b));

    }
}
