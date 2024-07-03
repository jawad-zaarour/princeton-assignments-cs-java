/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     14/02/1993
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        // generate the Thue–Morse sequence
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.bitCount(i) % 2;
        }

        // print the pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+");
                }
                else {
                    System.out.print("-");
                }
                if (j != n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
