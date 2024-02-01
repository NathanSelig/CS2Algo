package P2;

import java.util.Iterator;

public class Deque<Type> {

    private class Node {
        Type item;
        Node next;
        Node prev;
    }

    Node last; // newest person to enter the line does not know who is behind him
    Node first; // first person in line knows who is behind him in line he is at the register
    int sizeCounter;

    public Deque() {
        last = null;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return sizeCounter;
    }

    // adds items to the front of the line new first person they cut the line
    public void addFirst(Type item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()) {
            last = newNode;
            first = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        sizeCounter++;
    }

    // adds items to the back of the line new last person
    public void addLast(Type item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()) {
            last = newNode;
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        sizeCounter++;
    }

    // they leave the line bc they paid they were at the register in the first spot
    public Type removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node result = first;
        first = first.next;

        return result.item;
    }

    // they leave the line bc it is to long they were in the last spot
    public Type removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node result = last;
        last = last.prev;

        return result.item;
    }

    public Iterator<Type> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Type> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Type next() {
            Type item = current.item;
            current = current.next;
            return item;
        }

    }
}
