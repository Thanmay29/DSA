package Stack.Implimentation_Problems_Important;
import java.util.Stack;

// Class to implement a stack that also supports retrieving the minimum element in O(1) time
class MinStack {

    Stack<Integer> st;     // Main stack to store all values
    Stack<Integer> minSt;  // Stack to keep track of current minimum at every push

    // Constructor to initialize the stacks
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    // Push element onto the stack
    public void push(int val) {
        st.push(val);  // Push the value into main stack

        // If min stack is empty or the new value is less than or equal to the current min
        // push it into minSt (to track the new minimum)
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    // Remove the top element from the stack
    public void pop() {
        int popped = st.pop(); // Pop from main stack

        // If the popped value is equal to the top of minSt,
        // pop it from minSt too (as it's no longer in the stack)
        if (popped == minSt.peek()) {
            minSt.pop();
        }
    }

    // Return the top element of the stack
    public int top() {
        return st.peek();
    }

    // Return the current minimum element in the stack
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * This class tests the MinStack implementation
 */
public class O04_155_Min_Stack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current Min: " + minStack.getMin()); // Output: -3

        minStack.pop();
        System.out.println("Top Element: " + minStack.top());    // Output: 0
        System.out.println("Current Min: " + minStack.getMin()); // Output: -2
    }
}
