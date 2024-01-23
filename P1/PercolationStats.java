package P1;
import java.util.Random;

public class PercolationStats {
   public PercolationStats(int n, int trail, Percolation test){
       int size = n*n;
        for (int i = 0; i < size ; i++) {
            //pass
            if(test.percolates()){
                System.out.println(i/size);
            }
            //fail
            if(test.percolates()){
                //select random and run again
            }
            
        }
   }
}
