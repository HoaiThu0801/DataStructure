package doublelinkedlist;

public class DoubleLinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(Node node) {
        this.head = node;
    }

    public void insert (Node newNode){
        if (this.head == null){
            head = newNode;
            return;
        }
        Node lastNode = this.head;
        while (lastNode.getNext() != null){
            lastNode = lastNode.getNext();
        }
        newNode.setPrev(lastNode);
        lastNode.setNext(newNode);
    }

    public Node add (Node newNode){
        if (this.head != null){
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
        }
        this.head = newNode;
        return newNode;
    }
    public Node insertNthPosition(Node newNode, int position){
        if (position == 0){
            add(newNode);
            return newNode;
        }
        Node currNode = this.head;
        for (int i = 0; i <= position - 2; i ++){
            currNode = currNode.getNext();
        }
        newNode.setNext(currNode.getNext());
        currNode.getNext().setPrev(newNode);
        currNode.setNext(newNode);
        newNode.setPrev(currNode);
        return newNode;
    }
    public Boolean deleteNthPosition(int position){
        if (position == 0){
            this.head.getNext().setPrev(null);
            this.head = this.head.getNext();
            return true;
        }
        Node currNode = this.head;
        for (int i = 0; i <= position - 2; i ++){
            currNode = currNode.getNext();
            if (currNode == null){
                System.out.println("Invalid position");
                return false;
            }
        }
        currNode.getNext().getNext().setPrev(currNode);
        currNode.setNext(currNode.getNext().getNext());
        return true;
    }
    public int getSize (){
        int count = 0;
        Node currNode = this.head;
        while (currNode != null){
            count ++;
            currNode = currNode.getNext();
        }
        return count;
    }

    public int getElement(int index){
        Node currNode = this.head;
        for (int i = 0; i < index; i ++){
            currNode = currNode.getNext();
        }
        return currNode == null ? null : currNode.getData();
    }

    public void print(){
        Node currNode = this.head;
        while (currNode != null){
            System.out.print(currNode.getData() + " ");
            currNode = currNode.getNext();
        }
        System.out.println("\n");
    }

    public void printReverse(){
        Node currNode = this.head;
        while (currNode.getNext() != null){
            currNode = currNode.getNext();
        }
        while (currNode != null){
            System.out.print(currNode.getData() + " ");
            currNode = currNode.getPrev();
        }
        System.out.println("\n");
    }
}
