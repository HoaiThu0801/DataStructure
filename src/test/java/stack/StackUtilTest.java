package stack;

import linkedlist.Node;
import linkedlist.SingleLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static utils.StackUtil.*;
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
        Node node = new Node(1);

        SingleLinkedList singleLinkedList = new SingleLinkedList(node);

        node = new Node(2);
        singleLinkedList.insert(node);

        node = new Node(3);
        singleLinkedList.insert(node);

        node = new Node(4);
        singleLinkedList.insert(node);

        node = new Node(5);
        singleLinkedList.insert(node);

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
