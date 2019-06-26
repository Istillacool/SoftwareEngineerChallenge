package com.subash;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableQueueTest
{

    @Test
    public void testIsEmpty()
    {
        ImmutableQueue<Integer> queue = new ImmutableQueue<>();
        assertTrue("Queue should be empty", queue.isEmpty());
        assertFalse("Queue should not be empty", queue.enQueue(1)
                                                     .isEmpty());
        assertTrue("Intial Queue should be empty", queue.isEmpty());
    }

    @Test
    public void testDeque()
    {
        ImmutableQueue<Integer> queue = new ImmutableQueue<>();
        queue = queue.enQueue(111);
        assertTrue("Queue should be empty", queue.deQueue()
                                                .isEmpty());
        queue = queue.enQueue(1);
        assertTrue("Queue should be empty", queue.deQueue()
                                                .deQueue()
                                                .isEmpty());
        assertFalse("Intial Queue should not be empty", queue.enQueue(1)
                                                            .isEmpty());
    }

    @Test
    public void testHead()
    {
        ImmutableQueue<Integer> queue = new ImmutableQueue<>();
        Integer first =111;
        Integer second =11;
        Integer third =1;
        queue = queue.enQueue(first)
                    .enQueue(second)
                    .enQueue(third);

        assertEquals(first, queue.head());
        assertEquals(second, queue.deQueue().head());
        assertEquals(third, queue.deQueue().deQueue().head());


    }

}
