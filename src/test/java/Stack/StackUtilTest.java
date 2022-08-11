package Stack;

import Linkedlist.SingleLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.channels.SelectionKey;

import static Utils.StackUtil.checkBalancedParentheses;
import static Utils.StackUtil.reverse;
import static org.junit.jupiter.api.Assertions.*;

public class StackUtilTest {
    @Test
    @DisplayName("Test reverse string using stack")
    void testReverseString() {
        System.out.println(reverse("Hello"));
        assertEquals("olleH",  reverse("Hello"), "Reverse string went wrong");
    }
    @Test
    @DisplayName("Test reverse linked list using stack")
    void testReverseLinkedList() {
        SingleLinkedList singleLinkedList = new SingleLinkedList(1);
        singleLinkedList.insert(2);
        singleLinkedList.insert(3);
        singleLinkedList.insert(4);
        singleLinkedList.insert(5);

        singleLinkedList.printLinkedList();
        reverse(singleLinkedList).printLinkedList();
    }
    @Test
    @DisplayName("Test check parentheses function using stack")
    void testCheckBalancedParentheses(){
        //assertFalse(checkBalancedParentheses("({{[[[]]}))"), "check parentheses went wrong");
        assertTrue(checkBalancedParentheses("{[(())]}"), "check parentheses went wrong");
    }

}
