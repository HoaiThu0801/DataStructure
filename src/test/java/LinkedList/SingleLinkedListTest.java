package LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import Linkedlist.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {
    SingleLinkedList singleLinkedList;

    @BeforeEach
    void setUp() {
        singleLinkedList = new SingleLinkedList(1);
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
        singleLinkedList.insert(2);
        int insertedIndex = singleLinkedList.getSize() - 1;
        assertEquals(2, singleLinkedList.getElement(insertedIndex), "Insert method run unsuccessfully");
    }

    @Test
    @DisplayName("Test add method of single linked list")
    void testAdd(){
        singleLinkedList.add(3);
        assertEquals(3, singleLinkedList.getElement(0), "Add method run unsuccessfully");

        singleLinkedList.add(4);
        assertEquals(4, singleLinkedList.getElement(0), "Add methods went wrong");
    }

    @Test
    @DisplayName("Test insert nth method of single linked list")
    void testInsertNthPosition(){
        singleLinkedList.add(1);
        singleLinkedList.add(4);
        singleLinkedList.add(5);

        singleLinkedList.insertNthPosition(7,3);
        assertEquals(7, singleLinkedList.getElement(3), "Insert nth method run unsuccessfully");

        singleLinkedList.insertNthPosition(9, 2);
        assertEquals(9, singleLinkedList.getElement(2), "Insert nth method went wrong");
    }

    @Test
    @DisplayName("Test reverse method of single linked list")
    void testReverse(){
        singleLinkedList.add(2);
        singleLinkedList.add(4);
        singleLinkedList.add(5);

        singleLinkedList.printLinkedList();
        singleLinkedList.reverse();
        singleLinkedList.printLinkedList();

    }

    @Test
    @DisplayName("Test reverse recursion method of single linked list")
    void testReverseRecursion(){
        singleLinkedList.add(2);
        singleLinkedList.add(4);
        singleLinkedList.add(5);

        singleLinkedList.printLinkedList();
        singleLinkedList.reverseRecursion();
        singleLinkedList.printLinkedList();

    }

    @Test
    @DisplayName("Test delete method of single linked list")
    void testDeleteNthPosition(){
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.deleteNthPosition(1);

        assertNotEquals(2, singleLinkedList.getElement(1));
    }
}

