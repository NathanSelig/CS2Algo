import edu.princeton.cs.algs4.StdDraw;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        /*
         * StdDraw.setScale(0, 10);
         * StdDraw.setPenRadius(0.01);
         * StdDraw.setPenColor(StdDraw.BLACK);
         * Point[] control = new Point[8];
         * control[0] = new Point(5, 5);
         * control[1] = new Point(7, 7);
         * control[2] = new Point(6, 6);
         * control[3] = new Point(8, 8);
         * 
         * control[4] = new Point(11,13);
         * control[5] = new Point(12, 14);
         * control[6] = new Point(13, 15);
         * control[7] = new Point(14, 16);
         */
        // BruteCollinearPoints bruteMethod = new BruteCollinearPoints(randomSetup());

        FastCollinearPoints fastMethod = new FastCollinearPoints(randomSetup());

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(fastMethod.numberOfSegments());
        System.out.println(fastMethod.segments());
        System.out.println("Execution time in milliseconds  : " + totalTime);

    }

    public static Point[] randomSetup() {
        Random rng = new Random();
        int n = 1000;
        int size = 720;
        Point[] points = new Point[n];
        StdDraw.setCanvasSize(720, 720);
        StdDraw.setScale(0, 720);
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
