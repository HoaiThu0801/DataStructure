package Stack;


public class StackLinkedList {
    Node top;
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackLinkedList(int data) {
        this.top = new Node(data);
    }

    public StackLinkedList() {
    }

    public void push (int x){
        Node newNode = new Node(x);
        if (this.top != null){
            newNode.next = this.top;
        }
        this.top = newNode;
    }
    public void pop(){
        if (this.top == null){
            return;
        }
        this.top = this.top.next;
    }
    public int top(){
        return this.top.data;
    }
    public int getSize(){
        int count = 0;
        Node currNode = this.top;
        while (currNode != null){
            count++;
            currNode = currNode.next;
        }
        return count;
    }
    public void print(){
        System.out.println("Stack linked list");
        Node currNode = this.top;
        while (currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("\n");
    }
}
