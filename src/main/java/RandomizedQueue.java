import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] values;
    private int size;
    private int capacity;

    public RandomizedQueue() {
        capacity = 1;
        values = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        checkItem(item);
        if (size == capacity) {
            resize(capacity * 2);
        }

        values[size++] = item;
    }

    public Item dequeue() {
        checkBeforeAction();
        int position = StdRandom.uniform(size);
        Item item = values[position];
        values[position] = values[--size];
        values[size] = null;
        if (capacity / 4 > size) {
            resize(capacity / 2);
        }
        return item;
    }

    public Item sample() {
        checkBeforeAction();
        int position = StdRandom.uniform(size);
        return values[position];
    }

    private void resize(int newCapacity) {
        capacity = newCapacity;
        Item[] newArray = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = values[i];
        }

        values = newArray;
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void checkBeforeAction() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int iteratorSize = size;

        @Override
        public boolean hasNext() {
            return iteratorSize > 0;
        }

        @Override
        public Item next() {
            if (iteratorSize == 0) {
                throw new NoSuchElementException();
            }
            int randomIndex = StdRandom.uniform(iteratorSize);
            Item randomItem = values[randomIndex];
            values[randomIndex] = values[--iteratorSize];
            return randomItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
