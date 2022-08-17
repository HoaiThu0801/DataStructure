package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    BinarySearchTree binarySearchTree;
    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree(new BSTNode(1));
    }

    @Test
    @DisplayName("Test add and search method of binary search tree")
    void testAddAndSearch(){
        binarySearchTree.add(new BSTNode(2));
        binarySearchTree.add(new BSTNode(3));
        binarySearchTree.add(new BSTNode(4));
        binarySearchTree.add(new BSTNode(5));
        assertEquals(true, binarySearchTree.search(1), "Something went wrong");
        assertEquals(true, binarySearchTree.search(2), "Something went wrong");
        assertEquals(true, binarySearchTree.search(3), "Something went wrong");
        assertEquals(true, binarySearchTree.search(4), "Something went wrong");
        assertEquals(true, binarySearchTree.search(5), "Something went wrong");
        assertEquals(false, binarySearchTree.search(8), "Something went wrong");

    }
}
