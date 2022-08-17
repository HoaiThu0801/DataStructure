package tree;

public class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }

    public BinarySearchTree() {
    }

    public boolean add (BSTNode node){
        if (this.root == null){
            this.root = node;
        }
        else{
            BSTNode currNode = this.root;
            while(currNode.getLeft() != null || currNode.getRight() != null){
                if (currNode.getData() >= node.getData()){
                    currNode = currNode.getLeft();
                }
                else {
                    currNode = currNode.getRight();
                }
            }
            if (currNode.getData() >= node.getData()){
                currNode.setLeft(node);
            }
            else {
                currNode.setRight(node);
            }
        }
        return true;
    }
    private BSTNode addHelper(BSTNode root, BSTNode newNode){
        if (root == null){
            root = newNode;
            return root;
        } else if (root.getData() >= newNode.getData()) {
          return addHelper(root.getLeft(), newNode);
        }
        else  {
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
