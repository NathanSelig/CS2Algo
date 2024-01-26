package P1;

import java.util.Random;

public class PercolationStats {
   private double[] trialData;
   private Random ran;

   public PercolationStats(int n, int trail) {
      ran = new Random();
      trialData = new double[trail];
      for (int i = 0; i < trail; i++) {
         System.out.println("epoch: " + i);
         Percolation pr = new Percolation(n);
         while (!pr.percolates()) {
            int luckyNumber = ran.nextInt(n * n);
            pr.open(luckyNumber);
         }
         System.out.println("Hole found!");
         double openP = new Double(pr.numberOfOpenSites()) / (double)(n * n);
         trialData[i] = openP;
      }

   }
//* how to without array to store results
   public double mean() {
      double sum = 0;
      for (double i : trialData) {
         sum += i;
      }
      return sum / trialData.length;
   }

//!returning Nan
   public double stddev() {
      double sum = 0;
      for (double d : trialData) {
         double diff = (mean() - d) * (mean() - d);
         sum += diff;
      }
      return Math.sqrt(sum / trialData.length - 1);
   }

   public double confidenceLo() {
      // mean - 1.96s/t^1/2
      return mean() - ((1.96 * stddev()) / Math.sqrt(trialData.length));
   }

   public double confidenceHi() {
      // mean + 1.96s/t^1/2
      return mean() - ((1.96 * stddev()) / Math.sqrt(trialData.length));
   }

   public String toString() {
      String info = "mean: " + mean() + "\nstddev: " + stddev() + "\nconfLo: " + confidenceLo() + "\nconfHi: "
            + confidenceHi();
      return info;
   }
}
