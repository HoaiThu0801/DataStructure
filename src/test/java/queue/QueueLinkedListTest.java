package queue;

import linkedlist.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueLinkedListTest {
    QueueLinkedList queueLinkedList;
    @BeforeEach
    void setUp() {
        queueLinkedList = new QueueLinkedList(new Node(3));
    }
    @Test
    @DisplayName("Test front method of queue linked list")
    void testFront() {
        assertEquals(3, queueLinkedList.front(),
                "Test front method is incorrect");
    }
    @Test
    @DisplayName("Test enqueue method of queue array")
    void testEnqueue() {
        queueLinkedList.enqueue(new Node(2));
        assertEquals(2, queueLinkedList.rear(),
                "Test enqueue method is incorrect");
    }
    @Test
    @DisplayName("Test dequeue method of queue array")
    void testDequeue() {
        queueLinkedList.enqueue(new Node(2));
        queueLinkedList.enqueue(new Node(3));
        queueLinkedList.enqueue(new Node(4));

        assertEquals(3, queueLinkedList.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(2, queueLinkedList.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(3, queueLinkedList.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(4, queueLinkedList.dequeue(),
                "Test dequeue method is incorrect");
        assertEquals(-1, queueLinkedList.dequeue(),
                "Test dequeue method is incorrect");
    }
}
