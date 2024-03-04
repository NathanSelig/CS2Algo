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
            // sorts points to find origin
            Arrays.sort(points, i, points.length);
            Point origin = points[i];
            // sorts based of the new origin
            Arrays.sort(points, i, points.length, origin.slopeOrder());

            // slope being calculated and moved to slope array ignoring points that are now
            // origins
            for (int j = i + 1; j < points.length; j++) {
                double slope = origin.slopeTo(points[j]);
                slopes[j - 1] = slope;
            }

            // k = i because we want to only look at slopes that are relevant
            int k = i;
            int numOfSlopes = 0;
            while (k < slopes.length - 1) {
                if (slopes[k] == slopes[k + 1]) {
                    numOfSlopes++;
                }

                // Case: if more points are after the line
                if (numOfSlopes >= 2 && slopes[k] != slopes[k + 1]) {
                    LineSegment line = new LineSegment(origin, points[k + 1]);
                    /*
                     * StdDraw.setPenRadius(0.001);
                     * StdDraw.setPenColor(StdDraw.BLACK);
                     * line.draw();
                     */
                    lines.add(line);
                    numOfSlopes = 0;
                    // Case: if the line is at end of the slopes array
                } else if (numOfSlopes >= 2 && k == slopes.length - 2) {
                    LineSegment line = new LineSegment(origin, points[k + 2]);
                    /*
                     * StdDraw.setPenRadius(0.001);
                     * StdDraw.setPenColor(StdDraw.BLACK);
                     * line.draw();
                     */
                    lines.add(line);
                    numOfSlopes = 0;
                    // Case: if we have 2 equal slopes but not a line we need to
                    // reset numOfSlopes = 0
                } else if (numOfSlopes <= 2 && slopes[k] != slopes[k + 1]) {
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
