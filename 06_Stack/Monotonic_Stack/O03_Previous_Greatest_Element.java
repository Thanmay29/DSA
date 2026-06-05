package Stack.Monotonic_Stack;

import java.util.Stack;

public class O03_Previous_Greatest_Element {

    // Function to compute Previous Greater Element for each element in array
    public static void PGS(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse from left to right
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while top is smaller than or equal to current
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            // If stack is empty, no greater element to the left
            res[i] = st.isEmpty() ? -1 : st.peek();

            // Push current element to stack for future elements
            st.push(nums[i]);
        }

        // Print the result
        System.out.print("Previous Greater Elements: ");
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, 2, 20, 40, 12, 30};
        PGS(nums);
    }
}
