package LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import Linkedlist.Node;
import Linkedlist.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {
    SingleLinkedList singleLinkedList;

    @BeforeEach
    void setUp() {
        Node node = new Node(1);
        singleLinkedList = new SingleLinkedList(node);
    }

    @Test
    @DisplayName("Test get element method of single linked list")
    void testGetElelement() {
        assertEquals(1, singleLinkedList.getElement(0),
                "Get element method is incorrect");
    }
    @Test
    @DisplayName("Test get size method of single linked list")
    void testGetSize(){
        assertEquals(1, singleLinkedList.getSize(), "Something went wrong");
    }

    @Test
    @DisplayName("Test insert method of single linked list")
    void testInsert(){
        Node node = new Node(2);
        singleLinkedList.insert(node);
        int insertedIndex = singleLinkedList.getSize() - 1;
        assertEquals(2, singleLinkedList.getElement(insertedIndex), "Insert method run unsuccessfully");
    }

    @Test
    @DisplayName("Test add method of single linked list")
    void testAdd(){
        Node node = new Node(3);
        singleLinkedList.add(node);
        assertEquals(3, singleLinkedList.getElement(0), "Add method run unsuccessfully");

        node = new Node(4);
        singleLinkedList.add(node);
        assertEquals(4, singleLinkedList.getElement(0), "Add methods went wrong");
    }

    @Test
    @DisplayName("Test insert nth method of single linked list")
    void testInsertNthPosition(){
        Node node = new Node(4);
        singleLinkedList.add(node);

        node = new Node(4);
        singleLinkedList.add(node);

        node = new Node(5);
        singleLinkedList.add(node);

        node = new Node(7);
        singleLinkedList.insertNthPosition(node,3);
        assertEquals(7, singleLinkedList.getElement(3), "Insert nth method run unsuccessfully");

        node = new Node(9);
        singleLinkedList.insertNthPosition(node, 2);
        assertEquals(9, singleLinkedList.getElement(2), "Insert nth method went wrong");
    }

    @Test
    @DisplayName("Test reverse method of single linked list")
    void testReverse(){
        Node node = new Node(2);
        singleLinkedList.add(node);

        node = new Node(4);
        singleLinkedList.add(node);

        node = new Node(5);
        singleLinkedList.add(node);

        singleLinkedList.printLinkedList();
        singleLinkedList.reverse();
        singleLinkedList.printLinkedList();

    }

    @Test
    @DisplayName("Test reverse recursion method of single linked list")
    void testReverseRecursion(){
        Node node = new Node(2);
        singleLinkedList.add(node);

        node = new Node(4);
        singleLinkedList.add(node);

        node = new Node(5);
        singleLinkedList.add(node);

        singleLinkedList.printLinkedList();
        singleLinkedList.reverseRecursion();
        singleLinkedList.printLinkedList();

    }

    @Test
    @DisplayName("Test delete method of single linked list")
    void testDeleteNthPosition(){
        Node node = new Node(2);
        singleLinkedList.add(node);

        node = new Node(3);
        singleLinkedList.add(node);

        singleLinkedList.deleteNthPosition(1);

        assertNotEquals(2, singleLinkedList.getElement(1));
    }
}

