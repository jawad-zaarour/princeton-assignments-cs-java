/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     09/05/2024
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0, y = 0;
        int steps = 0;

        StdOut.println("(0, 0)");

        while ((Math.abs(x) + Math.abs(y)) < r) {
            double probabilty = Math.random();
            if (probabilty <= 0.25)
                x++;
            else if (probabilty <= 0.5)
                y++;
            else if (probabilty <= 0.75)
                x--;
            else
                y--;
            StdOut.printf("(%d, %d)\n", x, y);
            steps++;
        }

        StdOut.printf("steps = %d", steps);
    }
}
