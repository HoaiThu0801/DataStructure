package queue;

public class QueueArray {
    private int font = -1;
    private int rear = -1;
    private int[] queue;

    public QueueArray(int data, int size) {
        this.font += 1;
        this.rear += 1;
        this.queue = new int[size];
        this.queue[rear] = data;
    }

    public QueueArray(int size) {
        this.queue = new int[size];
    }

    public QueueArray() {
        this.queue = new int[100];
    }

    public int enqueue(int data){
        if ((this.rear + 1) % this.queue.length  == this.font){
            return -1;
        }
        if (isEmpty()){
            this.font = this.rear = data;
        }
        else {
            this.rear = (this.rear + 1) % this.queue.length;
        }
        this.queue[rear] = data;
        return data;
    }
    public int dequeue(){
        int result = -1;
        if (isEmpty()){
            return result;
        } else if (this.font == this.rear){
            result = this.queue[this.font];
            this.font = this.rear = -1;
            return result;
        }
        else {
            result = this.queue[this.font];
            this.font += 1;
            return result;
        }
    }
    public int front(){
        if (isEmpty()){
            return -1;
        }
        return this.queue[this.font];
    }
    public int rear(){
        if (isEmpty()){
            return -1;
        }
        return this.queue[this.rear];
    }
    public Boolean isEmpty(){
        return this.font == -1 && this.rear == -1 ? true : false;
    }
}
