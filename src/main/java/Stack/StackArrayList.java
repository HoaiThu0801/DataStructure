package Stack;

public class StackArrayList {
    int MAX_SIZE = 1000;
    int[] A = new int[MAX_SIZE];
    int top = -1;

    public StackArrayList() {
    }
    public StackArrayList(int x) {
        top = 0;
        this.A[top] = x;
    }
    public void push (int x){
        if (top == MAX_SIZE - 1){
            System.out.println("Stack overflow");
            return;
        }
       this.A[++top] = x;
    }
    public void pop(){
        if (this.top == -1){
            System.out.println("Emty stack");
            return;
        }
        --this.top;
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
