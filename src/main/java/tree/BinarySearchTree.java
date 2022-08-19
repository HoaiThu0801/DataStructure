package tree;

import queue.QueueArray;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }

    public BinarySearchTree() {
    }

    public BSTNode add (BSTNode node){
        return addHelper(this.root, node);
    }
    private BSTNode addHelper(BSTNode root, BSTNode newNode){
        if (root.getData() > newNode.getData()){
            if (root.getLeft() == null){
                root.setLeft(newNode);
                return root;
            }
            return addHelper (root.getLeft(), newNode);
        }
        else {
            if (root.getRight() == null){
                root.setRight(newNode);
                return root;
            }
            return addHelper(root.getRight(), newNode);
        }
    }

    public boolean search (int data){
        return searchHelper(this.root, data);
    }

    private boolean searchHelper(BSTNode root, int data){
        if (root == null){
            return false;
        }
        else if (root.getData() == data){
            return true;
        } else if (root.getData() >= data) {
            return searchHelper(root.getLeft(), data);
        } else {
            return searchHelper(root.getRight(), data);
        }
    }
    public int findMin(){
        BSTNode currNode = this.root;
        while (currNode.getLeft() != null){
            currNode = currNode.getLeft();
        }
        return currNode.getData();
    }
    public int findMax(){
        BSTNode currNode = this.root;
        while(currNode.getRight() != null){
            currNode = currNode.getRight();
        }
        return currNode.getData();
    }
    public int findHeight(){
        return findHeightHelper(this.root);
    }
    private int findHeightHelper(BSTNode node){
        if (node == null){
            return 0;
        }
        int leftHeight = findHeightHelper(node.getLeft());
            int rightHeight = findHeightHelper(node.getRight());
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public void levelOrderTraversal(){
        BSTNode currNode = this.root;
        Queue queue = new LinkedList<BSTNode>();
        queue.add(currNode);
        while (!queue.isEmpty()){
            currNode = (BSTNode) queue.poll();
            System.out.print(currNode.getData() + " ");
            if (currNode.getLeft() != null){
                queue.add(currNode.getLeft());
            }
            if (currNode.getRight() != null){
                queue.add(currNode.getRight());
            }
        }
        System.out.println("\n");
    }
}
