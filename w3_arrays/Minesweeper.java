/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     14/02/1993
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        char[][] grid = new char[m][n];

        // Initialize matrix with 0 cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '0';
            }
        }

        // Generate an m-by-n grid of cells, with exactly k of the cells containing *
        for (int placedMines = 0; placedMines < k; ) {
            int row = (int) (Math.random() * m);
            int col = (int) (Math.random() * n);
            if (grid[row][col] != '*') {
                grid[row][col] = '*';
                placedMines++;
            }
        }

        // Count neighboring mines
        int[] nx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] ny = { -1, 0, 1, -1, 1, -1, 0, 1 };

        // For each cell not containing a mine, count the number of neighboring mines
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '*') {
                    int count = 0;
                    for (int d = 0; d < 8; d++) {
                        int row = i + nx[d];
                        int col = j + ny[d];
                        if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '*') {
                            count++;
                        }
                    }
                    grid[i][j] = (char) (count + '0');
                }
            }
        }


        // Print the generated mine sweeper grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
                if (j != n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}