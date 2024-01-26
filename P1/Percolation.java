package P1;

public class Percolation {
    private int[] grid;
    private int width;
    private QuickUnion grouper;
    private int countOpenSquares;

    // create grid n-n
    public Percolation(int n) {
        // last 2 values in array are virtual points
        grid = new int[(n * n) + 2];
        this.width = n;
        grouper = new QuickUnion(grid);
        grid[grid.length - 1] = grid.length - 1;
        grid[grid.length - 2] = grid.length - 2;
        countOpenSquares = 0;
    }

    // * values == arr.length are blocked
    // if open in top row connect to virtual point same for bottom
    public void open(int index) {
        // guard for if already open
        if (isOpen(index))
            return;

        countOpenSquares++;
        grid[index] = index;
        int parent = index;
        // look around and make it children if open
        // (condition) ? (return if true) : (return if false);
        // index of surroundings

        // if the value of above == parent then at the top
        int above = (index - this.width) >= 0 ? index - this.width : index;
        int left = (index - 1) > 0 ? index - 1 : 0;
        int right = (index + 1) <= (area()) ? index + 1 : area();
        // if the value of below == parent then at the bottom
        int below = (index + this.width) < area() ? index + this.width : index;

        if (above != parent && isOpen(above)) {
            this.grouper.union(above, parent);
        } else if (above == parent) {
            // top virtual point is arr[-2]
            this.grouper.union(parent, area());
        }
        if (below != parent && isOpen(below)) {
            this.grouper.union(below, parent);
        } else if (isOpen(below)) {
            // bottom virtual point is area[-1]
            this.grouper.union(parent, area() + 1);
        }
        if (right != parent && isOpen(right)) {
            this.grouper.union(right, parent);
        } else if (isOpen(right)) {
            this.grouper.union(right, area() + 1);
        }
        if (left != parent && isOpen(left)) {
            this.grouper.union(left, parent);
        } else if (isOpen(left)) {
            this.grouper.union(left, area());
        }
    }

    public boolean isOpen(int index) {
        return !isFull(index);
    }

    public boolean isFull(int index) {
        return grid[index] == grid.length;
    }

    public int numberOfOpenSites() {
        return countOpenSquares;
    }

    public boolean percolates() {
        return grouper.connected(area(), area() + 1);
    }

    private int area() {
        // remove the 2 virtual points
        return this.grid.length - 2;
    }

    //print array as a table
    public String toString() {
        for (int i = 0; i < grid.length; i++) {
            System.out.print(grid[i] + " ");
            if(i%width == 0) {
                System.out.println("\n");
            }
        }
        return "\n";
    }

}