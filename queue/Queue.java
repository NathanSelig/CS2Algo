package queue;
// people in line at a store the person in first knows thr person behind them last is the most recent person to enter
public class Queue {
    private class Node {
        String item;
        Node next;
    }

    Node last;//where enqueue happens. last is the most recent element added.
    Node first; //where dequeue happens. first is the oldest item in the array

    public Queue() {
        last = null;
        first = null;
    }

    public void enqueue(String item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()) {
            last = newNode;
            first = newNode;
        } else {
        // the current last node points to the new last node the new last node is now the last node
            last.next = newNode;
            last = newNode;
        }

    }

    public String dequeue() {
        if (first == null) {
            return "";
        }
        Node result = first;
        first = first.next;

        //for testing
        System.out.println(result.item);
        return result.item;
    }

    public boolean isEmpty() {
        return last == null;
    }

}
