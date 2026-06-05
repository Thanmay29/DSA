package Stack.Monotonic_Stack;

import java.util.Stack;

public class O07_GFG_Sum_Of_SubArray_Maximum {

    public static int sumSubarrayMaxs(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;

        int[] pge = new int[n]; // Previous Greater Element count
        int[] nge = new int[n]; // Next Greater Element count

        Stack<Integer> st = new Stack<>();

        // Calculate distances to Previous Greater Element
        for (int i = 0; i < n; i++) {
            // Maintain elements in decreasing order in the stack
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element on left, so span is i + 1
            // Else, span is distance between current index and index of greater element
            pge[i] = st.isEmpty() ? i + 1 : i - st.peek(); // <-- Your question line
            st.push(i);
        }

        st.clear(); // Reset the stack for NGE calculation

        // Calculate distances to Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            // Maintain elements in decreasing order in the stack
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element on right, so span is n - i
            // Else, span is distance between current index and index of next greater element
            nge[i] = st.isEmpty() ? n - i : st.peek() - i; // <-- Your question line
            st.push(i);
        }

        // Calculate final result using contribution of each element
        long result = 0;
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * pge[i] * nge[i];
            result = (result + contribution) % mod;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2, 4};
        System.out.println("Sum of Subarray Maximums: " + sumSubarrayMaxs(arr1)); // Expected: 30

        int[] arr2 = {11, 81, 94, 43, 3};
        System.out.println("Sum of Subarray Maximums: " + sumSubarrayMaxs(arr2));
    }
}
