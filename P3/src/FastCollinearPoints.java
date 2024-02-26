import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    double[] slopes;
    ArrayList<LineSegment> lines;

    public FastCollinearPoints(Point[] points) {
        lines = new ArrayList<LineSegment>();
        Point origin = points[0];
        Arrays.sort(points, origin.slopeOrder());
        // slopes is length minus 1 because origin can not make slope with itself
        slopes = new double[points.length - 1];
        // starting at 1 because 0 is origin
        for (int i = 0; i < points.length; i++) {
            origin = points[i];
            for (int j = i + 1; j < points.length; j++) {
                double slope = origin.slopeTo(points[j]);
                slopes[j - 1] = slope;
            }
            Arrays.sort(slopes);
            int k = 0;
            //!if the first slopes are equal it will quit we need it to try again with the next points
            while (k < slopes.length - 1 ) {
                k++;
                if (k >= 2 && slopes[k] == slopes[k + 1]) {
                    LineSegment segment = new LineSegment(origin, points[i + k + 1]);
                    segment.draw();
                    lines.add(segment);
                }
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
