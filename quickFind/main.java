package quickFind;

public class main {

    public static void main(String[] args) {

        /* QuickFind test = new QuickFind(10); */
        QuickUnion test = new QuickUnion(10);
        // Tests:
        test.union(4, 3);
        test.union(3, 8);
        test.union(6, 5);
        test.union(9, 4);
        test.union(2, 1);
        test.connected(0, 7);
        test.connected(8, 9);
        test.union(5, 0);
        test.union(7, 2);
        test.union(6, 1);
        test.union(1, 0);
        test.connected(0, 7);

        test.toString();
    }

}