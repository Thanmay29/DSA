package PriorityQueue_Heap;

class Queue{
    int[] arr;
    int front;
    int rear;
    int cap;
    int size;

    public Queue(int cap){
        this.cap = cap;
        front = 0;
        arr = new int[cap];
        rear = -1;
        size = 0;
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue if Full");
            return;
        }

        rear = (rear+1) % cap;
        arr[rear] = val;
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = arr[front];
        front = (front+1) %cap;
        size--;
        return val;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return arr[front];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size == cap;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");
        for(int i=0; i<size; i++){
            System.out.print(arr[(front+1) % cap]+" ");
        }
        System.out.println();
    }
}

public class O01_GFG_Implement_Queue_Using_Array {

    public static void main(String[] args) {

    }
}
