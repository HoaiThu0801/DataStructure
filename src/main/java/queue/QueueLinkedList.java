package queue;

import linkedlist.Node;

public class QueueLinkedList {
    private Node font = null;
    private Node rear = null;

    public QueueLinkedList(Node data) {
        this.font = this.rear = data;
    }

    public QueueLinkedList() {
    }

    public int enqueue (Node data){
        if (isEmpty()){
            this.font = this.rear = data;
            return data.getData();
        }
        this.rear.setNext(data);
        this.rear = this.rear.getNext();
        return data.getData();

    }
    public int dequeue (){
        if (isEmpty()){
            return  -1;
        }
        int result = this.font.getData();
        if (this.font == this.rear){
            this.font = this.rear = null;
        }
        else {
            this.font = this.font.getNext();
        }
        return result;
    }
    public int front(){
        if (isEmpty()){
            return -1;
        }
        return this.font.getData();
    }
    public int rear(){
        if (isEmpty()){
            return -1;
        }
        return this.rear.getData();
    }
    public Boolean isEmpty (){
        return this.font == null && this.rear == null? true : false;
    }
}
