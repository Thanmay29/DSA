package Stack.Stack_And_Queue_Implementations;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class O03_Implement_Stack_Using_LinkedList {

    private Node top;
    private int size;

    public O03_Implement_Stack_Using_LinkedList(){
        top = null;
        size = 0;
    }

    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack Overflow");
        }
        int val = top.data;
        top = top.next;
        size--;

        return val;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack Overflow");
        }

        return top.data;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        O03_Implement_Stack_Using_LinkedList stack = new O03_Implement_Stack_Using_LinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop());        // 30
        System.out.println("Top after pop: " + stack.peek()); // 20
        System.out.println("Size: " + stack.size());          // 2
        System.out.println("Is Empty: " + stack.isEmpty());   // false
    }
}
