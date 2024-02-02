package P2;

public class main {
    public static void main(String[] args) {

        Deque<String> deque = new Deque<>();

        System.out.println("Is deque empty? " + deque.isEmpty());
        System.out.println("Deque size: " + deque.size());

        deque.addFirst("Alice");
        deque.addLast("Bob");

        System.out.println("Is deque empty? " + deque.isEmpty());
        System.out.println("Deque size: " + deque.size());

        System.out.println("First person in line: " + deque.removeFirst());
        System.out.println("Last person in line: " + deque.removeLast());

        System.out.println("Is deque empty? " + deque.isEmpty());
        System.out.println("Deque size: " + deque.size());

        // Additional tests
        System.out.println("Trying to remove from an empty deque: " + deque.removeFirst());
        System.out.println("Trying to remove from an empty deque: " + deque.removeLast());

        // Iterating through the deque
        deque.addFirst("Charlie");
        deque.addLast("Dave");

    }
}
