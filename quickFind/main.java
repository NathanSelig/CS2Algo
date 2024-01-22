package quickFind;

public class main {

    public static void main(String[] args) {

/*         QuickFind test = new QuickFind(10); */
        QuickUnion test = new QuickUnion(10);

        // Tests:
        test.union(4,3); 
        test.union(3,8);
        test.union(6,5);
        test.union(9,4);
        test.union(5,0);
        test.union(7,2);
        test.union(6,1);

        test.toString();
    }

}