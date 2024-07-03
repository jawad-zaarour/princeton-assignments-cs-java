/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        // Parse command-line arguments
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // Initialize array to count occurrences of each number of people
        int[] count = new int[n];

        for (int t = 0; t < trials; t++) {
            boolean[] birthdays = new boolean[n];
            // Number of people entered the room
            int peopleCount = 0;

            while (true) {
                // Generate random uniform birthday
                int birthday = (int) (Math.random() * n);
                peopleCount++;

                // Check if birthday already exists in the room
                if (birthdays[birthday]) {
                    break;
                }
                else {
                    birthdays[birthday] = true;
                }
            }

            // Increment the number of times that exactly i(peopleCount) people enter the room
            count[peopleCount]++;
        }

        // Calculate fraction
        double totalTrials = trials;
        double cumulativeFraction = 0;
        int i = 1;
        while (cumulativeFraction < 0.5 && i < count.length) {
            cumulativeFraction += count[i] / totalTrials;
            StdOut.printf("%d\t%d\t%.3f\n", i, count[i], cumulativeFraction);
            i++;
        }
    }
}
