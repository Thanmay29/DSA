package Stack.Stack_And_Queue_Implementations;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        q2.offer(x); // Step 1: Push to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll()); // Step 2: Transfer all from q1 to q2
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

//📦 Initial state:
//Let’s say we already have this:
//q1 = [3, 2, 1]  // Top of stack = 3 (at front)
//q2 = []         // Empty

//Now you do:
//push(4)
//📌 Step-by-step what happens in push(4):
//q2.offer(4);  // q2 becomes [4]

//Now:
//q2 = [4] → new element goes in first.
//q1 = [3, 2, 1]

//Now transfer all from q1 into q2:
//while (!q1.isEmpty()) {
//    q2.offer(q1.poll());
//}

//Loop executes:
//q1.poll() → 3 → q2.offer(3) → q2 = [4, 3]
//q1.poll() → 2 → q2.offer(2) → q2 = [4, 3, 2]
//q1.poll() → 1 → q2.offer(1) → q2 = [4, 3, 2, 1]

//After the loop:
//q1 = []
//q2 = [4, 3, 2, 1]

//Then we swap the queues:

//Queue<Integer> temp = q1;
//q1 = q2;
//q2 = temp;
//Now:
//q1 = [4, 3, 2, 1] → holds the stack
//q2 = [] → gets reused on the next push



    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return q1.poll(); // Always the front of q1
    }

    // Get the top element.
    public int top() {
        return q1.peek(); // Always the front of q1
    }

    // Returns whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}

public class O02_225_Implement_Stack_Using_Queues {

    public static void main(String[] args) {

    }
}
