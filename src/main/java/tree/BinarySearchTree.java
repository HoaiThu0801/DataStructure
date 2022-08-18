package tree;

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
}
