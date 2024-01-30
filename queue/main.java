package queue;

public class main {
   public static void main(String[] args) {
        Queue test = new Queue();
        test.enqueue("a");
        test.enqueue("b");
        test.enqueue("c");
        test.enqueue("d");
        test.enqueue("e");
        test.dequeue();
        test.enqueue("f");
        test.dequeue();
   } 
}
