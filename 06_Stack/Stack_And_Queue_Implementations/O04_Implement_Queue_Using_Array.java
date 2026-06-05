package Stack.Stack_And_Queue_Implementations;

class ArrayQueue {
    int[] arr;
    int cap;
    int front;
    int rear;
    public ArrayQueue(int cap) {
        this.cap = cap;
        rear = 0;
        front = 0;
        arr = new int[cap];
    }

    public void push(int x) {
        if(rear>=cap-1){
            System.out.println("Queue is full");
            return;
        }
        arr[rear++] = x;
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        return arr[front++];
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front==rear;
    }
}


public class O04_Implement_Queue_Using_Array {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Peek: " + q.peek());   // 10

        System.out.println("Pop: " + q.pop());     // 10
        System.out.println("Pop: " + q.pop());     // 20

        System.out.println("Peek: " + q.peek());   // 30

        q.push(40);
        q.push(50);
        q.push(60);   // Should hit "Queue is full" because rear==cap-1

        while (!q.isEmpty()) {
            System.out.println("Pop: " + q.pop());
        }

        System.out.println("Is Empty: " + q.isEmpty());
    }
}
