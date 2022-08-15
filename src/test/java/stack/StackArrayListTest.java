package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackArrayListTest
{
    StackArrayList stackArrayList;
    @BeforeEach
    void setUp() {
        stackArrayList = new StackArrayList(1);
    }

    @Test
    @DisplayName("Test top method of stack array list")
    void testTop() {
        assertEquals(1, stackArrayList.top(),
                "Get element method is incorrect");
    }

    @Test
    @DisplayName("Test push method of stack array list")
    void testPush() {
        stackArrayList.push(2);
        assertEquals(2, stackArrayList.top(),
                "Get element method is incorrect");
    }

    @Test
    @DisplayName("Test pop method of stack array list")
    void testPop() {
        stackArrayList.push(2);
        stackArrayList.push(3);
        stackArrayList.pop();
        assertEquals(2, stackArrayList.getSize(),
                "Get element method is incorrect");
    }

}
