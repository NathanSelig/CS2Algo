package P1;


public class main {
    public static void main(String[] args) {
        int gridLength = 20;
        Percolation test = new Percolation(gridLength);
        PercolationStats stats = new PercolationStats(gridLength, 1000000000, test);

    }

}
