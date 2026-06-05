package Stack.Monotonic_Stack;

import java.util.Stack;

public class O06_907_Sum_Of_SubArray_Minimums {

    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;

        int[] ple = new int[n]; // Previous Less Element distance
        int[] nle = new int[n]; // Next Less Element distance

        Stack<Integer> st = new Stack<>();


//Explanation:

//PLE (Previous Less Element): How far to the left the current element remains the smallest.
//NLE (Next Less Element): How far to the right the current element remains the smallest.
//The total number of subarrays where arr[i] is the minimum = PLE[i] * NLE[i].
//Each element contributes arr[i] * PLE[i] * NLE[i] to the final sum.

        // Calculate Previous Less Element distances
        for (int i = 0; i < n; i++) {
            // Pop while stack top is greater than current element
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            // If stack is empty, distance = i + 1, else distance from previous smaller
            ple[i] = st.isEmpty() ? i + 1 : i - st.peek();

            // Push current index onto the stack
            st.push(i);
        }

        st.clear();

        // Calculate Next Less Element distances
        for (int i = n - 1; i >= 0; i--) {
            // Pop while stack top is greater than or equal to current element
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            // If stack is empty, distance = n - i, else distance to next smaller
            nle[i] = st.isEmpty() ? n - i : st.peek() - i;

            // Push current index onto the stack
            st.push(i);
        }

        // Calculate final result using contribution of each element
        long result = 0;
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * ple[i] * nle[i];
            result = (result + contribution) % mod;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        O06_907_Sum_Of_SubArray_Minimums solver = new O06_907_Sum_Of_SubArray_Minimums();

        int[] arr1 = {3, 1, 2, 4};
        System.out.println("Sum of Subarray Minimums: " + solver.sumSubarrayMins(arr1));  // Output: 17

        int[] arr2 = {11, 81, 94, 43, 3};
        System.out.println("Sum of Subarray Minimums: " + solver.sumSubarrayMins(arr2));  // Output: 444
    }
}
