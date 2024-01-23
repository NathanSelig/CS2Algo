package P1;

public class Percolation {
    private int[] grid;
    private int width;

    // create grid n-n
    public Percolation(int n) {
        //last 2 values in array are virtual points
        grid = new int[(n * n)+2];
        this.width = n;
    }

    // * values == 0 are blocked 1 is assuming all parents are 1 the changing to
    //! implement quick union
    // if open in top row connect to virual point same for bottom
    public void open(int row, int col) {
        int index = (row * this.width) + col;
        grid[index] = index;
        int parent = index;
        // look around and make it children if open
        // (condition) ? (return if true) : (return if false);
        // index of surroundings

        // if the value of above == parent then at the top 
        int above = (index - this.width) > 0 ? index - this.width : index;
        int left = (index - 1) > 0 ? index - 1 : 0;
        int right = (index + 1) < (area()) ? index + 1 : area();
        // if the value of below == parent then at the bottom 
        int below = (index + this.width) < area() ? index + this.width : index;

        if(above != parent && isOpen(above)){
            union(above,parent);
        }else if (isOpen(above)){
            //top virtual point is arr[-2]
            union(parent,area()+1)
        }
        if(below != parent && isOpen(below)){
            union(below,parent);
        }else if(isOpen(below)){
            //bottom virtual point is area[-1]
            union(parent , area()+2)
        }
        if(right != parent && isOpen(above)){
            union(right,parent);
        }
        if(left != parent && isOpen(left)){
            union(left,parent);
        }

    }

    public boolean isOpen(int index) {
        return grid[index] == 0;
    }

    public boolean isFull(index) {
        return !isOpen(index);
    }

    public int numberOfOpenSites() {
        // check values == 0 count++
        return 0;
    }

    public boolean percolates() {
        //if bottom row has root at the top the percolates
        return false;
    }

    private int area() {
        //remove the 2 virtual points
        return this.grid.length-2;
    }

}