import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        checkItem(item);
        Node oldFirst = first;
        first = new Node(item);
        if (isEmpty()) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }

    public void addLast(Item item) {
        checkItem(item);
        Node oldLast = last;
        last = new Node(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        size++;
    }

    public Item removeFirst() {
        checkBeforeRemove();
        Node oldFirst = first;
        first = oldFirst.next;
        if (first != null) {
            first.prev = null;
        }
        size--;
        return oldFirst.value;
    }

    public Item removeLast() {
        checkBeforeRemove();
        Node oldLast = last;
        last = oldLast.prev;
        if (last != null) {
            last.next = null;
        }
        size--;
        return oldLast.value;
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void checkBeforeRemove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node {
        private Item value;
        private Node next;
        private Node prev;

        public Node(Item value) {
            this.value = value;
        }
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item value = current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
