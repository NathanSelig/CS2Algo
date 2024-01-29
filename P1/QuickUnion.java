package P1;

//class copied from ../quickFind/QuickUnion.java
//slightly modified

public class QuickUnion {

    private int[] arr;

    public QuickUnion(int[] n) {
        this.arr = n;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length;
        }
    }

    public void union(int p, int q) {
        // value is the parent of the index
        // q is the parent of p so find index p and set value to q
        int i = root(p);
        int j = root(q);
        arr[i] = j;
    }

    public int root(int p) {
        // work up using "pointers" till i == arr[i]
        // parent is value saved in p

        while (p != arr[p]) {
            p = arr[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        if (root(p) == root(q)) {
            return true;
        }
        return false;
    }

    public String toString() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ":" + arr[i]);
        }

        return "/n";
    }

}
