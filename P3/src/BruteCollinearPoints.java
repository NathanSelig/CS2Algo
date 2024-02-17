import java.util.ArrayList;

import edu.princeton.cs.algs4.StdDraw;

public class BruteCollinearPoints {
    Point[] points;
    ArrayList<LineSegment> lines;
    int lineCount;

    public BruteCollinearPoints(Point[] points) {
        this.points = points;
        lines = new ArrayList<LineSegment>();
        // top level
        for (int i = 0; i < points.length; i++) {
            Point root = points[i];
            StdDraw.setPenColor(StdDraw.RED);
            root.draw();
            // second point search
            for (int j = i + 1; j < points.length; j++) {
                Point q = points[j];
                double slope = root.slopeTo(q);
                // third point search
                for (int k = j + 1; k < points.length; k++) {
                    Point r = points[k];
                    if (slope != root.slopeTo(r)) {
                        continue;
                    }
                    // fourth point search
                    for (int l = k + 1; l < points.length; l++) {
                        Point s = points[l];
                        if (slope != root.slopeTo(s)) {
                            continue;
                        }
                        StdDraw.setPenColor(StdDraw.BLUE);
                        s.draw();
                        // we have a line
                        //draw the points on the line
                        StdDraw.setPenRadius(0.01);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        q.draw();
                        r.draw();
                        s.draw();
                        root.draw();
                        //draw the line and add it to the LineSegment array
                        //* sometimes the root or the last point is in the "middle" of the line so the line is not fully drawn
                        lines.add(new LineSegment(root, s));
                        StdDraw.setPenColor(StdDraw.GRAY);
                        StdDraw.setPenRadius(0.001);
                        lines.get(lineCount).draw();
                        lineCount++;
                        break;
                    }
                }
            }
            StdDraw.setPenColor(StdDraw.WHITE);
            root.draw();
        }
    }

    public int numberOfSegments() {
        return lineCount;
    }

    public ArrayList<LineSegment> segments() {
        return lines;
    }
}
