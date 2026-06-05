package Stack.Monotonic_Stack;

import java.util.Arrays;
import java.util.Stack;

public class O15__Maximum_of_Minimum_for_Every_Window_Size_GFG {

    public static int[] maxOfMin(int[] arr){

        // Stack to store indices for monotonic increasing order
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        // left[i] = index of previous smaller element of arr[i]
        int[] left = new int[n];

        // Find Previous Smaller Element (PSE) for each index
        for(int i = 0; i < n; i++){
            // Pop until smaller element is found
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }

            // If none found, boundary is -1
            left[i] = st.isEmpty() ? -1 : st.peek();

            // Push current index
            st.push(i);
        }

        // Clear stack to reuse for right side computation
        st.clear();

        // right[i] = index of next smaller element of arr[i]
        int[] right = new int[n];

        // Find Next Smaller Element (NSE) for each index
        for(int i = n - 1; i >= 0; i--){
            // Pop until smaller element is found
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }

            // If none found, boundary is n (end of array)
            right[i] = st.isEmpty() ? n : st.peek();

            // Push current index
            st.push(i);
        }

        // res[k] = maximum of minimums for window size k+1
        int[] res = new int[n];

        // Initialize with very small values
        Arrays.fill(res, Integer.MIN_VALUE);

        // Calculate window length where arr[i] is minimum
        for(int i = 0; i < n; i++){
            int len = right[i] - left[i] - 1;

            // Store max value among all minimums for this window size
            res[len - 1] = Math.max(res[len - 1], arr[i]);
        }

        // Fill missing values using larger window results
        // Because max of min decreases as window size increases
        for(int i = n - 2; i >= 0; i--){
            res[i] = Math.max(res[i], res[i + 1]);
        }

        // Final result for all window sizes 1 to n
        return res;
    }

    static void main() {
        int[] arr = {10,20,30,50,10,70,30};
        System.out.println(Arrays.toString(maxOfMin(arr)));
    }
}
