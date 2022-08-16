package linkedlist;

public class SingleLinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public SingleLinkedList() {
    }
    public SingleLinkedList(Node node) {
        this.head = node;
    }

    public void insert (Node newNode){
        if (head == null){
            this.head = newNode;
        }
        else {
            Node last = this.head;
            while (last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(newNode);
        }
    }
    public void insert(SingleLinkedList list){
        if (this.head == null){
            this.head = list.head;
            return;
        }
        Node last = this.head;
        while (last.getNext() != null){
            last = last.getNext();
        }
        last.setNext(list.head);
    }
    public void add (Node newNode){
        if (this.head != null) {
            newNode.setNext(this.head);
        }
        this.head = newNode;
    }
    public void insertNthPosition (Node newNode, int position){
        if (position == 0){
            add(newNode);
        }
        Node currNode = this.head;
        for (int i = 0; i <= position - 2; i ++){
            currNode = currNode.getNext();
            if (currNode == null){
                System.out.println("Invalid position");
                return;
            }
        }
        newNode.setNext(currNode.getNext());
        currNode.setNext(newNode);
    }
    public void  deleteNthPosition (int position)
    {
        if (position == 0){
            this.head = this.head.getNext();
        }
        else {
            Node temp = this.head;
            for (int i = 0; i <= position - 2; i ++){
                temp = temp.getNext();
                if (temp == null){
                    System.out.println();
                    System.out.println("Invalid position");
                    return;
                }
            }
            temp.setNext(temp.getNext().getNext());
        }
    }
    public void reverse (){
        Node prev, curr, next;
        curr = this.head;
        prev = null;
        while (curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }
    public void reverseRecursion(){
        reverseRecursionHelper(this.head);
    }

    public void reverseRecursionHelper(Node head){
        if (head.getNext() == null){
            this.head = head;
            return;
        }
        reverseRecursionHelper(head.getNext());
        Node currNode = head.getNext();
        currNode.setNext(head);
        head.setNext(null);
    }
    public int getElement (int index){
        Node currNode = this.head;
        for (int i = 0; i < index; i ++){
            currNode = currNode.getNext();
        }
        return currNode == null ? null : currNode.getData();
    }

    public int getSize (){
        Node currNode = this.head;
        int count = 0;
        while (currNode != null){
            currNode = currNode.getNext();
            count ++;
        }
        return count;
    }
    public void printLinkedList (){
        System.out.println("Linked listed: ");
        Node temp = this.head;
        while (temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println("\n");
    }
}

