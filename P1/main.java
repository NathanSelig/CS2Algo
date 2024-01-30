package P1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        PercolationStats test = new PercolationStats(4, 1);
        System.out.println(test);

        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

}
