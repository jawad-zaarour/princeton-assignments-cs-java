/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {

    // Method to solve the Reve's puzzle
    public static void solve(int n, String start, String auxiliary1, String auxiliary2,
                             String end) {
        // Calculate k using the Frame-Stewart algorithm
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        // Recursive call to move k smallest disks to auxiliary1
        reves(n, k, start, auxiliary1, auxiliary2, end);
    }

    // Method to recursively move disks
    private static void reves(int n, int k, String start, String auxiliary1, String auxiliary2,
                              String end) {
        if (n == 0) return;

        // Move the k smallest disks from start to auxiliary1
        moveDisks(k, start, end, auxiliary2, auxiliary1);

        // Move the remaining n - k disks from start to end
        moveDisks(n - k, start, auxiliary2, auxiliary1, end);

        // Move the k smallest disks from auxiliary1 to end
        moveDisks(k, auxiliary1, start, auxiliary2, end);
    }

    // Method to move disks using the 3-pole Tower of Hanoi algorithm
    private static void moveDisks(int n, String start, String auxiliary1, String auxiliary2,
                                  String end) {
        if (n == 0) return;
        moveDisks(n - 1, start, end, auxiliary2, auxiliary1);
        StdOut.println("Move disc " + n + " from " + start + " to " + end);
        moveDisks(n - 1, auxiliary1, start, auxiliary2, end);
    }

    // Main method to parse command line arguments and initiate the puzzle
    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        solve(4, "A", "B", "C", "D");
    }
}

