package linkedlist;

public class SingleLinkedList {
    Node head;

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
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }
    public void insert(SingleLinkedList list){
        if (this.head == null){
            this.head = list.head;
            return;
        }
        Node last = this.head;
        while (last.next != null){
            last = last.next;
        }
        last.next = list.head;
    }
    public void add (Node newNode){
        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
    }
    public void insertNthPosition (Node newNode, int position){
        if (position == 0){
            add(newNode);
        }
        Node currNode = this.head;
        for (int i = 0; i <= position - 2; i ++){
            currNode = currNode.next;
            if (currNode == null){
                System.out.println("Invalid position");
                return;
            }
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }
    public void  deleteNthPosition (int position)
    {
        if (position == 0){
            this.head = this.head.next;
        }
        else {
            Node temp = this.head;
            for (int i = 0; i <= position - 2; i ++){
                temp = temp.next;
                if (temp == null){
                    System.out.println();
                    System.out.println("Invalid position");
                    return;
                }
            }
            temp.next = temp.next.next;
        }
    }
    public void reverse (){
        Node prev, curr, next;
        curr = this.head;
        prev = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }
    public void reverseRecursion(){
        reverseRecursionHelper(this.head);
    }

    public void reverseRecursionHelper(Node head){
        if (head.next == null){
            this.head = head;
            return;
        }
        reverseRecursionHelper(head.next);
        Node currNode = head.next;
        currNode.next = head;
        head.next = null;
    }
    public int getElement (int index){
        Node currNode = this.head;
        for (int i = 0; i < index; i ++){
            currNode = currNode.next;
        }
        return currNode == null ? null : currNode.data;
    }

    public int getSize (){
        Node currNode = this.head;
        int count = 0;
        while (currNode != null){
            currNode = currNode.next;
            count ++;
        }
        return count;
    }
    public void printLinkedList (){
        System.out.println("Linked listed: ");
        Node temp = this.head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
}

