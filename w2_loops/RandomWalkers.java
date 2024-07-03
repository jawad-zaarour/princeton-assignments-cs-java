/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     09/05/2024
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double avg = 0;

        for (int i = 0; i < trials; i++) {
            int x = 0, y = 0;
            int steps = 0;
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

                steps++;
            }
            avg += steps;
        }


        StdOut.printf("average number of steps = %f", avg / trials);
    }
}
