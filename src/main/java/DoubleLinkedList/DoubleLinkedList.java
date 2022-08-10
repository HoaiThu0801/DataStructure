package DoubleLinkedList;

public class DoubleLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(int data) {
        this.head = new Node(data);
    }

    public void insert (int data){
        Node newNode = new Node(data);
        if (this.head == null){
            head = newNode;
            return;
        }
        Node lastNode = this.head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }
        newNode.prev = lastNode;
        lastNode.next = newNode;
    }

    public void add (int data){
        Node newNode = new Node(data);
        if (this.head != null){
            newNode.next = this.head;
            this.head.prev = newNode;
        }
        this.head = newNode;
    }
    public void insertNthPosition(int data, int position){
        if (position == 0){
            add(data);
            return;
        }
        Node newNode = new Node(data);
        Node currNode = this.head;
        for (int i = 0; i <= position - 2; i ++){
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next.prev = newNode;
        currNode.next = newNode;
        newNode.prev = currNode;
    }
    public int getSize (){
        int count = 0;
        Node currNode = this.head;
        while (currNode != null){
            count ++;
            currNode = currNode.next;
        }
        return count;
    }

    public int getElement(int index){
        Node currNode = this.head;
        for (int i = 0; i < index; i ++){
            currNode = currNode.next;
        }
        return currNode == null ? null : currNode.data;
    }
}
