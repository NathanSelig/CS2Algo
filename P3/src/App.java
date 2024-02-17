import edu.princeton.cs.algs4.StdDraw;
import java.util.Random;

public class App {
    public static void main(String[] args) {

/*         StdDraw.setScale(0,10);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        Point[] control = new Point[4];
        control[0] = new Point(5, 5);
        control[1] = new Point(6, 6);
        control[2] = new Point(7,7 );
        control[3] = new Point(8, 8);
        for (Point point : control) {
           point.draw(); 
        } */


        BruteCollinearPoints bruteMethod = new BruteCollinearPoints(randomSetup());
        
        System.out.println(bruteMethod.numberOfSegments());
        System.out.println(bruteMethod.segments());
    }

    public static Point[] randomSetup() {
        Random rng = new Random();
        int n = 100;
        int size = 245;
        Point[] points = new Point[n];
        StdDraw.setScale(-1,250);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++) {
            int x = rng.nextInt(size);
            int y = rng.nextInt(size);
            points[i] = new Point(x, y);
        }

        return points;
    }
}
