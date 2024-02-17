package P2;

import java.util.Iterator;
import java.util.Random;

/**
 * RandomizedQueue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    Item[] queue;
    Random ran;
    int topPointer;

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        // starting size?
        queue = (Item[]) new Object[0];
        ran = new Random();
        topPointer = -1;
    }

    public boolean isEmpty() {
        return topPointer == -1;
    }

    private int arrLength() {
        return queue.length;
    }

    public int size() {
        return topPointer + 1;
    }

    public void enqueue(Item item) {
        if (arrLength() - 1 == topPointer) {
            resize((arrLength() + 1) * 2);
        }

        queue[++topPointer] = item;
    }

    public Item dequeue() {
        int randomNum = ran.nextInt(size() - 1);
        Item result = queue[randomNum + 1];
        // switch top value and result
        queue[randomNum] = queue[size() - 1];
        queue[size() - 1] = result;

        if (topPointer >= 0 && topPointer == arrLength() / 4) {
            resize(arrLength() / 2);
        }

        topPointer--;
        return result;
    }

    public Item sample() {
        int randomNum = ran.nextInt(size() - 1);
        return queue[randomNum];
    }

    private void resize(int newSize) {
        @SuppressWarnings("unchecked")
        Item[] copy = (Item[]) new Object[newSize];
        for (int i = 0; i < size(); i++) {
            copy[i] = queue[i];
        }
        queue = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();

    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int pointer = topPointer;
        Item[] queueCopy = queue.clone();

        @Override
        public boolean hasNext() {
            return pointer >= 0;
        }

        @Override
        public Item next() {
            return iteratorDequeue();
        }

        private Item iteratorDequeue() {
            int randomNum = ran.nextInt(pointer + 1);
            Item result = queueCopy[randomNum];
            // move the top value to the result and move pointer down 1
            queueCopy[randomNum] = queueCopy[pointer];

            pointer--;
            return result;
        }
    }

}
