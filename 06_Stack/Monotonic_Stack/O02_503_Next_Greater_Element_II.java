package Stack.Monotonic_Stack;

import java.util.Stack;

public class O02_503_Next_Greater_Element_II {

    // Method to find the next greater elements in a circular array
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; // Result array to store next greater elements
        Stack<Integer> st = new Stack<>(); // Stack to keep track of candidates for next greater elements

        // Traverse the array in reverse order twice (simulate circular array)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n; // Circular index, wraps around the array

            // Pop all elements from the stack that are less than or equal to nums[idx]
            while (!st.isEmpty() && st.peek() <= nums[idx]) {
                st.pop();
            }

            // Only fill result during the first pass (i < n)
            if (i < n) {
                // If stack is empty, there is no greater element; otherwise top is the answer
                res[idx] = st.isEmpty() ? -1 : st.peek();
            }

            // Push current element to stack to help find next greater for future elements
            st.push(nums[idx]);
        }

        return res;
    }

    public static void main(String[] args) {
        O02_503_Next_Greater_Element_II obj = new O02_503_Next_Greater_Element_II();
        int[] nums = {1, 2, 1};
        int[] result = obj.nextGreaterElements(nums);

        System.out.print("Next greater elements: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: 2 -1 2
    }
}
