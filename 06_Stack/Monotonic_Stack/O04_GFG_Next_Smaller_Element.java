package Stack.Monotonic_Stack;

import java.util.Stack;

public class O04_GFG_Next_Smaller_Element {

    public static void NSE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for(int i=n-1; i>=0;i--){

            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        System.out.println("Next Smaller Elements: ");
        for(int val : res){
            System.out.print(val+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 11, 13, 21, 3 };
        NSE(arr);
    }
}
