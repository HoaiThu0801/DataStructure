package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class QueueArrayTest {
    QueueArray queueArray;
    @BeforeEach
    void setUp() {
        queueArray = new QueueArray(1, 10);
    }
    @Test
    @DisplayName("Test front method of queue array")
    void testFront() {
        assertEquals(1, queueArray.front(),
                "Test front method is incorrect");
    }
    @Test
    @DisplayName("Test enqueue method of queue array")
    void testEnqueue() {
        queueArray.enqueue(2);
        assertEquals(2, queueArray.rear(),
                "Test enqueue method is incorrect");
    }
    @Test
    @DisplayName("Test dequeue method of queue array")
    void testDequeue() {
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);

        assertEquals(1, queueArray.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(2, queueArray.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(3, queueArray.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(4, queueArray.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(-1, queueArray.dequeue(),
                "Test dequeue method is incorrect");
    }
}
