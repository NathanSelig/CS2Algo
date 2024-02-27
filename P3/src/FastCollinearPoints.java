import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints {
    double[] slopes;
    ArrayList<LineSegment> lines;

    public FastCollinearPoints(Point[] points) {
        lines = new ArrayList<LineSegment>();
        slopes = new double[points.length - 1];
        // slopes is length minus 1 because origin can not make slope with itself
        for (int i = 0; i < points.length; i++) {
            Arrays.sort(points, i, points.length);
            Point origin = points[i];
            Arrays.sort(points, i, points.length, origin.slopeOrder());

            // being calculated and moved
            for (int j = i + 1; j < points.length; j++) {
                double slope = origin.slopeTo(points[j]);
                slopes[j - 1] = slope;
            }

            //not i plus 1 because slope size is -1 of points
            int k = i;
            int numOfSlopes = 0;
            while (k < slopes.length - 1) {
                if (slopes[k] == slopes[k + 1]) {
                    numOfSlopes++;
                }

                // Case: if more points after the line
                if (numOfSlopes >= 2 && slopes[k] != slopes[k + 1]) {
                    LineSegment line = new LineSegment(origin, points[k + 1]);
/*                     StdDraw.setPenRadius(0.001);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    line.draw(); */
                    lines.add(line);
                    numOfSlopes = 0;
                    // Case: if line is at end of array
                } else if (numOfSlopes >= 2 && k == slopes.length - 2) {
                    LineSegment line = new LineSegment(origin, points[k + 2]);
/*                     StdDraw.setPenRadius(0.001);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    line.draw(); */
                    lines.add(line);
                    numOfSlopes = 0;
                    //Case: if we have 2 slopes that are equal and then nothing more we need to reset numOfSlopes = 0
                }else if(numOfSlopes <= 2 && slopes[k] != slopes[k + 1]){
                    numOfSlopes = 0;
                }
                k++;
            }
        }
    }

    public int numberOfSegments() {
        return lines.size();
    }

    public ArrayList<LineSegment> segments() {
        return lines;
    }
}
