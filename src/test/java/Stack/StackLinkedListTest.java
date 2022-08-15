package Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackLinkedListTest {
    StackLinkedList stackLinkedList;
    @BeforeEach
    void setUp() {
        stackLinkedList = new StackLinkedList(1);
    }

    @Test
    @DisplayName("Test top method of stack array list")
    void testTop() {
        assertEquals(1, stackLinkedList.top(),
                "Get element method is incorrect");
    }

    @Test
    @DisplayName("Test push method of stack array list")
    void testPush() {
        stackLinkedList.push(2);
        assertEquals(2, stackLinkedList.top(),
                "Get element method is incorrect");
    }

    @Test
    @DisplayName("Test pop method of stack array list")
    void testPop() {
        stackLinkedList.push(2);
        stackLinkedList.push(3);
        stackLinkedList.pop();
        assertEquals(2, stackLinkedList.getSize(),
                "Get element method is incorrect");
    }
}
