package DoubleLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DoubleLinkedListTest {
    DoubleLinkedList doubleLinkedList;

    @BeforeEach
    void setUp() {
        doubleLinkedList = new DoubleLinkedList(1);
    }

    @Test
    @DisplayName("Test get element method of double linked list")
    void testGetElelement() {
        assertEquals(1, doubleLinkedList.getElement(0),
                "Get element method is incorrect");
    }
    @Test
    @DisplayName("Test get size method of double linked list")
    void testGetSize(){
        assertEquals(1, doubleLinkedList.getSize(), "Something went wrong");
    }
    @Test
    @DisplayName("Test insert method of double linked list")
    void testInsert(){
        doubleLinkedList.insert(2);
        int index = doubleLinkedList.getSize() - 1;
        assertEquals(2, doubleLinkedList.getElement(index), "Insert method runs unsuccessfully");
    }
    @Test
    @DisplayName("Test add method of double linked list")
    void testAdd(){
        doubleLinkedList.add(3);
        assertEquals(3, doubleLinkedList.getElement(0), "Add method runs unsuccessfully");
    }
    @Test
    @DisplayName("Test double method of double linked list")
    void testInsertNthPosition(){
        doubleLinkedList.add(6);
        doubleLinkedList.add(2);
        doubleLinkedList.add(4);
        doubleLinkedList.add(5);
        doubleLinkedList.insertNthPosition(3,2);
        assertEquals(3, doubleLinkedList.getElement(2), "Insert method runs unsuccessfully");
    }

    @Test
    @DisplayName("Test delete method of double linked list")
    void testDeleteNthPosition(){
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        doubleLinkedList.deleteNthPosition(1);

        assertNotEquals(2, doubleLinkedList.getElement(1));
    }
    @Test
    @DisplayName("Test print reverse method of double linked list")
    void testPrintReverse(){
        doubleLinkedList.add(6);
        doubleLinkedList.add(2);
        doubleLinkedList.add(4);
        doubleLinkedList.add(5);

        doubleLinkedList.print();
        doubleLinkedList.printReverse();
    }

}
