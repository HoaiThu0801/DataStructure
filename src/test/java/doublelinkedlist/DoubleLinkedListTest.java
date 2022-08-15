package doublelinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DoubleLinkedListTest {
    DoubleLinkedList doubleLinkedList;

    @BeforeEach
    void setUp() {
        Node node = new Node(1);
        doubleLinkedList = new DoubleLinkedList(node);
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
        Node node = new Node(2);
        doubleLinkedList.insert(node);
        int index = doubleLinkedList.getSize() - 1;
        assertEquals(2, doubleLinkedList.getElement(index), "Insert method runs unsuccessfully");
    }
    @Test
    @DisplayName("Test add method of double linked list")
    void testAdd(){
        Node node = new Node(3);
        doubleLinkedList.add(node);
        assertEquals(3, doubleLinkedList.getElement(0), "Add method runs unsuccessfully");
    }
    @Test
    @DisplayName("Test double method of double linked list")
    void testInsertNthPosition(){
        Node node = new Node(6);
        doubleLinkedList.add(node);

        node = new Node(2);
        doubleLinkedList.add(node);

        node = new Node(4);
        doubleLinkedList.add(node);

        node = new Node(5);
        doubleLinkedList.add(node);

        node = new Node(3);
        doubleLinkedList.insertNthPosition(node,2);
        assertEquals(3, doubleLinkedList.getElement(2), "Insert method runs unsuccessfully");
    }

    @Test
    @DisplayName("Test delete method of double linked list")
    void testDeleteNthPosition(){

        Node node = new Node(2);
        doubleLinkedList.add(node);

        node = new Node(3);
        doubleLinkedList.add(node);

        doubleLinkedList.deleteNthPosition(1);

        assertNotEquals(2, doubleLinkedList.getElement(1));
    }
    @Test
    @DisplayName("Test print reverse method of double linked list")
    void testPrintReverse(){
        Node node = new Node(6);
        doubleLinkedList.add(node);

        node = new Node(2);
        doubleLinkedList.add(node);

        node = new Node(4);
        doubleLinkedList.add(node);

        node = new Node(5);
        doubleLinkedList.add(node);

        doubleLinkedList.print();
        doubleLinkedList.printReverse();
    }

}
