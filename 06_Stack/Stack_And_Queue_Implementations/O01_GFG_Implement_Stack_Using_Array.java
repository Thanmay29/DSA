package Stack.Stack_And_Queue_Implementations;

class Stack{
    int top, cap;
    int[] a;

    public Stack(int cap){
        this.cap = cap;
        top = -1;
        a = new int[cap];
    }

    public boolean push(int x){
        if(top>=cap-1){
            System.out.println("Stack OverFlow");
            return false;
        }
        a[++top] = x;
        return true;
    }

    public int pop(){
        if(top<0){
            System.out.println("Stack is Empty");
            return 0;
        }
        return a[top--];
    }

    public int peek(){
        if(top<0){
            System.out.println("Stack is Empty");
            return 0;
        }
        return a[top];
    }

    public boolean isEmpty(){
        return top<0;
    }
}

public class O01_GFG_Implement_Stack_Using_Array {

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " popped from stack");

        System.out.println("Top element is: " + s.peek());

        System.out.print("Elements present in stack: ");
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
