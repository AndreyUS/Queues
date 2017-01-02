import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTest {

    private final static String FIRST_ITEM = "FIRST_ITEM";
    private final static String SECOND_ITEM = "SECOND_ITEM";
    private final static String THIRD_ITEM = "THIRD_ITEM";

    private Deque<String> deque;

    @Before
    public void setUp() throws Exception {
        deque = new Deque<>();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testIsNotEmpty() throws Exception {
        deque.addFirst(FIRST_ITEM);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, deque.size());
        deque.addFirst(FIRST_ITEM);
        assertEquals(1, deque.size());
    }

    @Test
    public void testAddFirst() throws Exception {
        deque.addFirst(FIRST_ITEM);
        assertFalse(deque.isEmpty());
        deque.addFirst(SECOND_ITEM);
        assertEquals(2, deque.size());
        String firstAdded = deque.removeLast();
        assertEquals(FIRST_ITEM, firstAdded);
        String secondAdded = deque.removeLast();
        assertEquals(SECOND_ITEM, secondAdded);
    }

    @Test
    public void testAddLast() throws Exception {
        deque.addLast(FIRST_ITEM);
        String item = deque.removeFirst();
        assertEquals(FIRST_ITEM, item);
        deque.addLast(FIRST_ITEM);
        deque.addLast(SECOND_ITEM);
        deque.addLast(THIRD_ITEM);
        assertEquals(3, deque.size());
    }

    @Test
    public void testRemoveFirst() throws Exception {
        deque.addFirst(FIRST_ITEM);
        String item = deque.removeFirst();
        assertEquals(FIRST_ITEM, item);

        deque.addLast(FIRST_ITEM);
        String item2 = deque.removeFirst();
        assertEquals(FIRST_ITEM, item2);

        deque.addLast(FIRST_ITEM);
        deque.addLast(SECOND_ITEM);
        deque.addLast(THIRD_ITEM);
        assertEquals(FIRST_ITEM, deque.removeFirst());
        assertEquals(SECOND_ITEM, deque.removeFirst());
        assertEquals(THIRD_ITEM, deque.removeFirst());


        deque.addFirst(FIRST_ITEM);
        deque.addFirst(SECOND_ITEM);
        deque.addFirst(THIRD_ITEM);
        assertEquals(THIRD_ITEM, deque.removeFirst());
        assertEquals(SECOND_ITEM, deque.removeFirst());
        assertEquals(FIRST_ITEM, deque.removeFirst());
    }

    @Test
    public void testRemoveLast() throws Exception {
        deque.addLast(FIRST_ITEM);
        assertEquals(FIRST_ITEM, deque.removeFirst());

        deque.addLast(FIRST_ITEM);
        assertEquals(FIRST_ITEM, deque.removeLast());

        deque.addLast(FIRST_ITEM);
        deque.addLast(SECOND_ITEM);
        deque.addLast(THIRD_ITEM);
        assertEquals(THIRD_ITEM, deque.removeLast());
        assertEquals(SECOND_ITEM, deque.removeLast());
        assertEquals(FIRST_ITEM, deque.removeLast());

        deque.addLast(FIRST_ITEM);
        deque.addLast(SECOND_ITEM);
        deque.addLast(THIRD_ITEM);
        assertEquals(FIRST_ITEM, deque.removeFirst());
        assertEquals(SECOND_ITEM, deque.removeFirst());
        assertEquals(THIRD_ITEM, deque.removeFirst());
    }

    @Test(expected = NullPointerException.class)
    public void testAddFirstNull() throws Exception {
        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddLastNull() throws Exception {
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyRemoveFirst() throws Exception {
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyRemoveLast() throws Exception {
        deque.removeLast();
    }

    @Test
    public void testIterator() throws Exception {
        deque.addLast(FIRST_ITEM);
        deque.addLast(SECOND_ITEM);
        deque.addLast(THIRD_ITEM);

        final Iterator<String> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(FIRST_ITEM, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(SECOND_ITEM, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(THIRD_ITEM, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveOperation() throws Exception {
        Iterator<String> iterator = deque.iterator();
        iterator.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyNext() throws Exception{
        Iterator<String> iterator = deque.iterator();
        iterator.next();
    }
}