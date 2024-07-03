/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {

    public static void main(String[] args) {
        StdAudio.playInBackground("soundtrackB.wav");
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String[] lines = new In(args[0]).readAllLines();

        // Read the header
        String title = lines[0];
        String xAxisLabel = lines[1];
        String dataSource = lines[2];

        // Create a BarChart instance
        BarChart barChart = new BarChart(title, xAxisLabel, dataSource);

        // Process each year
        int index = 4;
        while (index < lines.length) {
            String line = lines[index];

            // Skip empty lines
            if (line.isEmpty()) {
                index++;
                continue;
            }

            // Read each record and create Bar objects
            int numRecords = Integer.parseInt(line);
            Bar[] bars = new Bar[numRecords];
            for (int j = 0; j < numRecords; j++) {
                index++;
                line = lines[index];
                String[] tokens = line.split(",");
                bars[j] = new Bar(tokens[1], Integer.parseInt(tokens[3]), tokens[4]);
            }

            // Sort bars by value and add top k bars to BarChart
            int k = Integer.parseInt(args[1]);
            int threshold = Math.max(0, bars.length - k);

            Arrays.sort(bars);
            for (int j = bars.length - 1; j >= threshold; j--) {
                if (bars[j].getValue() > 0) {
                    barChart.add(bars[j].getName(), bars[j].getValue(), bars[j].getCategory());
                }
            }

            barChart.setCaption(line.split(",")[0]);
            reDraw(barChart);
            index++;

        }
    }

    private static void reDraw(BarChart barChart) {
        StdDraw.clear();
        barChart.draw();
        StdDraw.show();
        StdDraw.pause(100);
        barChart.reset();
    }
}
