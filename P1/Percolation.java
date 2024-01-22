package P1;

public class Percolation {
    private int[] grid;
    private int width;

    //create grid n-n
    public Percolation(int n){
        grid = new int[n*n];
        this.width = n;
        
        //set all values to 1 initially blocked
        //* this may be silly and take extra time going through whole array could switch 1 to open 0 to closed
        for (int i = 0; i < grid.length; i++) {
            
        }


    }

    public void open(int row, int col){
        int index = (row*this.width) + col;
        grid[index] = 0;
    }

    public boolean isOpen(int row, int col){
        // 1 is closed 0 is open
        int index = (row*this.width) + col;
        return grid[index] == 0;
    }
    public boolean isFull(int row, int col){
        return !isOpen(row, col);
    }

    public int numberOfOpenSites(){}

    public boolean percolates(){
        //there are n*n plots so a for loop will run n*n loops
        //in each square find related square

    }

}