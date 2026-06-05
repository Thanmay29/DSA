package Stack.Monotonic_Stack;

import java.util.Stack;

public class O05_Previous_Smallest_Element {

    public static void PSE(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && st.peek()>=nums[i]){
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();

            st.push(nums[i]);
        }

        System.out.println("Previous Smallest Element: ");
        for(int val : res){
            System.out.print(val+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 7};
        PSE(nums);
    }
}
