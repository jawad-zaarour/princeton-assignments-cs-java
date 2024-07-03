/* *****************************************************************************
 *  Name:              Jawad Zaarour
 *  Coursera User ID:  123456
 *  Last modified:     21/4/2024
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        System.out.println("DDD");
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int vertices = StdIn.readInt();
            double[] xCoordinates = new double[vertices];
            double[] yCoordinates = new double[vertices];

            for (int i = 0; i < vertices; i++) {
                xCoordinates[i] = StdIn.readDouble();
                yCoordinates[i] = StdIn.readDouble();
            }
            StdDraw.polygon(xCoordinates, yCoordinates);

        }
        StdDraw.show();
    }
}
