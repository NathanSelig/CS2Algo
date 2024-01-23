package quickFind;

public class QuickUnion {

    private int[] arr;

    public QuickUnion(int n) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
    /*
     * union(4,3)
     * arr[4] = 3
     * union(3,8)
     * arr[3] = 8
     * union(6,5)
     * arr[6] = 5
     */

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
        if (root(p) == root(q)){
            System.out.println("connected");
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
