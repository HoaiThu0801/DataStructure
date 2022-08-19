package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTest {
    BinarySearchTree binarySearchTree;
    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree(new BSTNode(8));
        binarySearchTree.add(new BSTNode(4));
        binarySearchTree.add(new BSTNode(3));
        binarySearchTree.add(new BSTNode(2));
        binarySearchTree.add(new BSTNode(5));
        binarySearchTree.add(new BSTNode(6));
        binarySearchTree.add(new BSTNode(1));
        binarySearchTree.add(new BSTNode(14));
        binarySearchTree.add(new BSTNode(17));
        binarySearchTree.add(new BSTNode(15));
        binarySearchTree.add(new BSTNode(12));
    }
    @Test
    @DisplayName("Test add and search method of binary search tree")
    void testAddAndSearch(){
        binarySearchTree.add(new BSTNode(10));
        binarySearchTree.add(new BSTNode(11));
        assertEquals(true, binarySearchTree.search(1), "Something went wrong");
        assertEquals(true, binarySearchTree.search(2), "Something went wrong");
        assertEquals(true, binarySearchTree.search(3), "Something went wrong");
        assertEquals(true, binarySearchTree.search(4), "Something went wrong");
        assertEquals(true, binarySearchTree.search(5), "Something went wrong");
        assertEquals(true, binarySearchTree.search(12), "Something went wrong");
        assertEquals(true, binarySearchTree.search(15), "Something went wrong");
        assertEquals(false, binarySearchTree.search(19), "Something went wrong");
    }
    @Test
    @DisplayName("Test find min method of binary search tree")
    void testFindMin(){
        binarySearchTree.add(new BSTNode(10));
        binarySearchTree.add(new BSTNode(11));
        assertEquals(1, binarySearchTree.findMin(), "Find min method went wrong");
    }
    @Test
    @DisplayName("Test find max method of binary search tree")
    void testFindMax(){
        binarySearchTree.add(new BSTNode(10));
        binarySearchTree.add(new BSTNode(11));
        assertEquals(17, binarySearchTree.findMax(), "Find max method went wrong");
    }
    @Test
    @DisplayName("Test find height method of binary search tree")
    void testFindHeight(){
        binarySearchTree.add(new BSTNode(10));
        binarySearchTree.add(new BSTNode(11));
        assertEquals(5, binarySearchTree.findHeight(), "Find max method went wrong");
    }
    @Test
    @DisplayName("Test level order traversal method of binary search tree")
    void testLevelOrderTraversal(){
        binarySearchTree.add(new BSTNode(10));
        binarySearchTree.add(new BSTNode(11));
        binarySearchTree.levelOrderTraversal();
    }
}
