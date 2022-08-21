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
        System.out.println("Level order traversal");
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

    public void preOrderTraversal(){
        System.out.println("Pre order traversal");
        preOrderTraversalHelper(this.root);
        System.out.println("\n");
    }
    private void preOrderTraversalHelper(BSTNode root){
        if (root == null){
            return;
        }
        System.out.print(root.getData() + " ");
        preOrderTraversalHelper(root.getLeft());
        preOrderTraversalHelper(root.getRight());
    }

    public void inOrderTraversal(){
        System.out.println("In order traversal");
        inOrderTraversalHelper(this.root);
        System.out.println("\n");
    }
    private void inOrderTraversalHelper(BSTNode root){
        if (root == null){
            return;
        }
        preOrderTraversalHelper(root.getLeft());
        System.out.print(root.getData() + " ");
        preOrderTraversalHelper(root.getRight());
    }

    public void postOrderTraversal(){
        System.out.println("Post order traversal");
        postOrderTraversalHelper(this.root);
        System.out.println("\n");
    }
    private void postOrderTraversalHelper(BSTNode root){
        if (root == null){
            return;
        }
        preOrderTraversalHelper(root.getLeft());
        preOrderTraversalHelper(root.getRight());
        System.out.print(root.getData() + " ");
    }
    public Boolean isBinarySearchTree(){
        return isBinarySearchTreeHelper(this.root, -9999999, 9999999);
    }
    private Boolean isBinarySearchTreeHelper(BSTNode root, int minValue, int maxValue){
        if (root == null){
            return true;
        }
        if (root.getData() > minValue && root.getData() < maxValue
                && isBinarySearchTreeHelper(root.getLeft(), minValue, root.getData())
                && isBinarySearchTreeHelper(root.getRight(), root.getData(), maxValue)){
            return true;

        }
        return false;
    }
    public BSTNode delete(int data){
        return deleteHelper(this.root, data);
    }
    public BSTNode deleteHelper(BSTNode root, int data){
        if (root == null){
            return root;
        }
        if (root.getData() > data){
            root.setLeft(deleteHelper(root.getLeft(), data));
        } else if (root.getData() < data) {
            root.setRight(deleteHelper(root.getRight(), data));
        }
        else {
            if (root.getLeft() == null && root.getRight() == null){
                root = null;
            } else if (root.getLeft() == null) {
                root = root.getRight();
            } else if (root.getRight() == null) {
                root = root.getLeft();
            }
            else {
                BSTNode temp = findMin(root.getRight());
                root.setData(temp.getData());
                root.setRight(deleteHelper(root.getRight(), temp.getData()));
            }
        }
        return root;
    }
    private BSTNode findMin(BSTNode root){
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }
    public BSTNode inorderSuccessor(int data){
        return getSuccessor(this.root, data);
    }
    private BSTNode getSuccessor(BSTNode root, int data){
        BSTNode currNode = find(root, data);
        if (currNode == null){
            return currNode;
        }
        if (currNode.getRight() != null){
            return findMin(currNode.getRight());
        } else {
            BSTNode successor = null;
            BSTNode ancestor = root;
            while (!ancestor.equals(currNode)){
                if (ancestor.getData() > currNode.getData()){
                    successor = ancestor;
                    ancestor = ancestor.getLeft();
                }
                else {
                    ancestor = ancestor.getRight();
                }
            }
            return successor;
        }
    }
    private BSTNode find(BSTNode root, int data){
        if (root == null){
            return root;
        }
        if (root.getData() == data){
            return root;
        } else if (root.getData() > data) {
            return find(root.getLeft(), data);
        } else {
            return find(root.getRight(), data);
        }
    }
}
