import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedQueueTest {

    private RandomizedQueue<Integer> randomizedQueue;


    @Before
    public void setUp() throws Exception {
        randomizedQueue = new RandomizedQueue<>();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(randomizedQueue.isEmpty());
        randomizedQueue.enqueue(1);
        assertFalse(randomizedQueue.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, randomizedQueue.size());
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        assertEquals(3, randomizedQueue.size());
    }

    @Test
    public void testDequeue() throws Exception {
        randomizedQueue.enqueue(1);
        assertEquals(Integer.valueOf(1), randomizedQueue.dequeue());

        for (int i = 0; i < 10; i++) {
            randomizedQueue.enqueue(1);
        }

        assertEquals(10, randomizedQueue.size());

        for (int i = 0; i < 10; i++) {
            randomizedQueue.dequeue();
            assertNotEquals(10 - i, randomizedQueue.size());
        }
    }

    @Test
    public void testSample() throws Exception {
        randomizedQueue.enqueue(1);
        randomizedQueue.sample();
        assertEquals(1, randomizedQueue.size());
    }
}