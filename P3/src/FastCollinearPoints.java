import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints {
    double[] slopes;
    ArrayList<LineSegment> lines;

    public FastCollinearPoints(Point[] points) {
        lines = new ArrayList<LineSegment>();

        // slopes is length minus 1 because origin can not make slope with itself
        // starting at 1 because 0 is origin
        for (int i = 0; i < points.length; i++) {
            Arrays.sort(points, i, points.length);
            Point origin = points[i];
            Arrays.sort(points, i, points.length, origin.slopeOrder());
            slopes = new double[points.length - i - 1];

            // !need to debug this for the slopes because slopes of unwanted points
            // *decided to change to making an array with a new size instead
            // being calculated and moved
            for (int j = i + 1; j < points.length; j++) {
                double slope = origin.slopeTo(points[j]);
                slopes[j - 1 - i] = slope;
            }
            int k = 0;
            int numOfSlopes = 0;
            while (k < slopes.length - 1) {
                if (slopes[k] == slopes[k + 1]) {
                    numOfSlopes++;
                }
                if (numOfSlopes >= 2 && slopes[k] != slopes[k + 1]) {
                    LineSegment line = new LineSegment(origin, points[k + i + 1]);
                    StdDraw.setPenRadius(0.001);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    line.draw();
                    lines.add(line);
                    numOfSlopes = 0;
                } else if (numOfSlopes >= 2 && k == slopes.length - 2) {
                    LineSegment line = new LineSegment(origin, points[k + i + 2]);
                    StdDraw.setPenRadius(0.001);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    line.draw();
                    lines.add(line);
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
