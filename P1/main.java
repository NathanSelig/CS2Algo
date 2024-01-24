package P1;

public class main {
    public static void main(String[] args) {
        int gridLength = 3;
        Percolation test = new Percolation(gridLength);
        PercolationStats stats = new PercolationStats(gridLength, 1000000000, test);
        for (int i = 0; i < gridLength; i++) {
            test.open(i, 1);
            if(test.percolates()){
                System.out.println("theres a hole!");
                System.out.println(test.numberOfOpenSites());
            }
        }
        
    }

}
