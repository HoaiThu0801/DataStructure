package stack;

public class StackArrayList {
    private int MAX_SIZE = 1000;
    private int[] A;
    private int top = -1;

    public StackArrayList(int size) {
        A = new int[size];
    }
    public StackArrayList(int x, int size) {
        A = new int[size];
        top = 0;
        this.A[top] = x;
    }
    public int push (int x){
        if (top == MAX_SIZE - 1){
            System.out.println("Stack overflow");
            return -1;
        }
       this.A[++top] = x;
        return x;
    }
    public int pop(){
        if (this.top == -1){
            System.out.println("Emty stack");
            return -1;
        }
        int result = this.top;
        --this.top;
        return  result;
    }
    public int top(){
        return A[top];
    }
    public int getSize(){
        return top + 1;
    }
    public void print(){
        System.out.println("Stack: ");
        for (int i = 0; i <= top; i ++){
            System.out.print(A[i] + " ");
        }
        System.out.println("\n");
    }
}
