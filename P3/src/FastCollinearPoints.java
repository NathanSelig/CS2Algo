import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    double[] slopes;
    ArrayList<LineSegment> lines;

    public FastCollinearPoints(Point[] points) {
        lines = new ArrayList<LineSegment>();
        // slopes is length minus 1 because origin can not make slope with itself
        // starting at 1 because 0 is origin
        for (int i = 0; i < points.length; i++) {
            Point origin = points[i];
            slopes = new double[points.length - i - 1];
            Arrays.sort(points, i, points.length, origin.slopeOrder());
            for (int j = i + 1; j < points.length; j++) {
                double slope = origin.slopeTo(points[j]);
                slopes[j - i - 1] = slope;
            }
            int k = 0;
            int numOfSlopes = 0;
            while (k < slopes.length - 1) {
                if (slopes[k] == slopes[k + 1]) {
                    numOfSlopes++;
                }
                if (numOfSlopes >= 2 && (slopes[k] != slopes[k + 1] || k == slopes.length - 2)) {
                    LineSegment line = new LineSegment(origin, points[k + 1 + i]);
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
