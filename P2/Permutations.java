package P2;

import java.util.Iterator;
import java.util.Scanner;



public class Permutations {
    RandomizedQueue<String> collection;
    Scanner scanner;
    int K;

    public Permutations() {
        collection = new RandomizedQueue<String>();
        scanner = new Scanner(System.in);
        K = getK();
    }

    public void run(){
        getStrings();
        printCollection();
    }

    private int getK() {
        System.out.println("please provide value for K");
        return scanner.nextInt();
    }

    private void getStrings() {
        while (true) {
            System.out.print("next Word: ");
            String word = scanner.next();
            if(word.equals("q")){
                break;
            }
            collection.enqueue(word);
        }
        System.out.println("now printing");
    }

    private void printCollection() {
        Iterator<String> i = (Iterator<String>) collection.iterator();
        while(i.hasNext() && K > 0){
            System.out.println(i.next());
            K--;
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        test.run();
    }
}
