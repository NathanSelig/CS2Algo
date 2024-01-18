package quickFind;

public class QuickFind {
    private int[] arr;

    public QuickFind(int n) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void union(int p, int q) {
        // if the points are connected quit
        if (this.arr[p] == this.arr[q]) {
            return;
        }

        int mainVal = this.arr[p];
        int changeVal = this.arr[q];
        //loops array looking for changeVal and changing the value to mainVal
        for (int i = 0; i < arr.length; i++) {
            if(find(i) == changeVal){
                this.arr[i] = mainVal;
            }
        }

    }

    public int find(int p) {
        return this.arr[p];
    }

    public boolean connected(int p, int q) {

        if (find(p) == find(q)) {
            System.out.println("connection!");
            return true;
        }
        System.out.println("Nope!");
        return false;
    }

    public String toString() {
        for (int i : arr) {
            System.out.println(i);
        }
        return "/n";
    }

}
