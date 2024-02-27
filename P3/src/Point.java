
import java.util.*;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    public final int x; // x-coordinate of this point
    public final int y; // y-coordinate of this point

    // Initializes a new point.
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // Draws this point to standard draw.
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     */
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        double x2 = that.x;
        double y2 = that.y;
        double x1 = this.x;
        double y1 = this.y;

        if (y2 == y1) {
            return Double.NEGATIVE_INFINITY;
        }
        if (x2 == x1) {
            return Double.POSITIVE_INFINITY;
        }

        return (y2 - y1) / (x2 - x1);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     */
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        double x2 = that.x;
        double y2 = that.y;
        double x1 = this.x;
        double y1 = this.y;

        if (y1 < y2) {
            return -1;
        } else if (y1 > y2) {
            return 1;
        }
        if (x1 < x2) {
            return -1;
        } else if (x1 > x2) {
            return 1;
        }
        return 0;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     */
    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
        return new pointComparator();
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }


    private class pointComparator implements Comparator<Point> {
        
        @Override
        public int compare(Point arg0, Point arg1) {
            double slope1 = slopeTo(arg0);
            double slope2 = slopeTo(arg1);
            if(slope1 > slope2){
                return 1;
            }else if(slope1 < slope2){
                return -1;
            }
            return 0;
        }
        
    }
    /**
     * Unit tests for the Point data type.
     */
    public static void main(String[] args) {
        /* YOUR CODE HERE */
       Point p1 = new Point(0,0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 3);

        //1
        System.out.println(p1.slopeTo(p2));
        //1.5
        System.out.println(p1.slopeTo(p3));
        //2
        System.out.println(p2.slopeTo(p3));
        //neg inf
        System.out.println(p1.slopeTo(p1));

        System.out.println("-----------------");
        //-1 less
        System.out.println(p1.compareTo(p2));
        //-1 less
        System.out.println(p1.compareTo(p3));
        //1 greater 
        System.out.println(p3.compareTo(p1));
        //0 same
        System.out.println(p1.compareTo(p1));

        System.out.println("-----------------");
        //p3 slope is greater
        System.out.println(p1.slopeOrder().compare(p2, p3));
    }
}