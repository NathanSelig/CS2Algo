package P1;

import java.util.Random;

public class PercolationStats {
   private double[] trialData;
   private Random ran;
   private double sum;

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
         // for testing
         // System.out.println(pr);
         System.out.println("Hole found!");
         double openP = new Double(pr.numberOfOpenSites()) / (double) (n * n);
         trialData[i] = openP;
         sum += openP;
      }

   }

   public double mean() {
      return sum / trialData.length;
   }

   // !returning Nan
   public double stddev() {
      double diffSum = 0;
      for (double d : trialData) {
         double diff = Math.pow(d - mean(), 2);
         diffSum += diff;
      }
      return Math.sqrt((diffSum / (trialData.length - 1)));
   }

   public double confidenceLo() {
      // mean - 1.96s/sqrt(t)
      return mean() - ((1.96 * stddev()) / Math.sqrt(trialData.length));
   }

   public double confidenceHi() {
      // mean + 1.96s/sqrt(t)
      return mean() + ((1.96 * stddev()) / Math.sqrt(trialData.length));
   }

   public String toString() {
      String info = "\nmean: " + mean() + "\nstddev: " + stddev() + "\nconfLo: " + confidenceLo() + "\nconfHi: "
            + confidenceHi();
      return info;
   }
}
