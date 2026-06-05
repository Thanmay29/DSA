package Stack.Stack_And_Queue_Implementations;

import java.util.Stack;

// Class to implement Queue using two Stacks
class MyQueue {
    Stack<Integer> s1; // Stack for pushing new elements
    Stack<Integer> s2; // Stack for popping and peeking

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue operation (add element to queue)
    public void push(int x) {
        s1.push(x); // Always push to s1
    }

    // Dequeue operation (remove front of queue)
    public int pop() {
        shiftStack();       // Ensure s2 has current front
        return s2.pop();    // Pop from s2 (front of queue)
    }

    // Peek the front element without removing
    public int peek() {
        shiftStack();       // Ensure s2 has current front
        return s2.peek();   // Return the front element
    }

    // Check if the queue is empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty(); // Queue is empty only if both stacks are empty
    }

    // Helper method to move elements from s1 to s2 (if s2 is empty)
    private void shiftStack() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop()); // Reverse s1 into s2
            }
        }
    }
}

// Main class to test MyQueue
public class O05_Implement_Queue_using_Stacks {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        // Push elements into queue
        q.push(10);
        q.push(20);
        q.push(30);

        // Output the front element (should be 10)
        System.out.println("Peek: " + q.peek()); // Output: 10

        // Pop front element
        System.out.println("Pop: " + q.pop()); // Output: 10

        // Check front again (should now be 20)
        System.out.println("Peek: " + q.peek()); // Output: 20

        // Push another element
        q.push(40);

        // Pop all elements
        System.out.println("Pop: " + q.pop()); // Output: 20
        System.out.println("Pop: " + q.pop()); // Output: 30
        System.out.println("Pop: " + q.pop()); // Output: 40

        // Check if queue is empty
        System.out.println("Is queue empty? " + q.empty()); // Output: true
    }
}
