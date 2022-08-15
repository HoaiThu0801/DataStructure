package Stack;

import Linkedlist.SingleLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.channels.SelectionKey;

import static Utils.StackUtil.*;
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
    @Test
    @DisplayName("Test convert infix to postfix function using stack")
    void testInfixToPostfix(){
        assertEquals("ABC*+", infixToPostfix("A+B*C"), "convert infix to postfix function something went wrong");
        assertEquals("AB+C*", infixToPostfix("(A+B)*C"), "convert infix to postfix function something went wrong");
        assertEquals("ABC*DE*-+", infixToPostfix("A+B*C-D*E"), "convert infix to postfix function something went wrong");
    }
}
