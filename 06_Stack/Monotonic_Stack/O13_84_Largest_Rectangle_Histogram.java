package Stack.Monotonic_Stack;

import java.util.Stack;

public class O13_84_Largest_Rectangle_Histogram {

    //<--------------------uses 1 stack (Single-Pass)--------------------> use this for interviews
    public static int UsingSinglePass(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? -1 : heights[i];
            while (!st.isEmpty() && curr < heights[st.peek()]) {
                int h = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                max = Math.max(max, h * width);
            }
            st.push(i);
        }

        return max;
    }

    public static void main(String[] args) {

        //<--------------------uses 1 stack (Single-Pass)--------------------> use this for interviews
        int[] heights4 = {2,1,5,6,2,3};
        System.out.println(UsingSinglePass(heights4));//10

        int[] heights5 = {2,1,2,3,2,3};
        System.out.println(UsingSinglePass(heights5));//8

        int[] heights6 = {2,4};
        System.out.println(UsingSinglePass(heights6));//4

        //<----------------Using right smallest element and left smallest element----------------->
        //<---------------------uses 2 Stack(two-pass)---------------->
        int[] heights1 = {2,1,5,6,2,3};
        System.out.println(UsingLseRse(heights1));//10

        int[] heights2 = {2,1,2,3,2,3};
        System.out.println(UsingLseRse(heights2));//8

        int[] heights3 = {2,4};
        System.out.println(UsingLseRse(heights3));//4
    }

    //<----------------Using right smallest element and left smallest element----------------->
    //<---------------------uses 2 Stack(two-pass)---------------->
    public static int UsingLseRse(int[] heights) {
        int[] rse = rse(heights);//right smallest element
        int[] lse = lse(heights);//left smallest element

        int area = Integer.MIN_VALUE;

        for(int i=0; i<heights.length; i++){
            int currArea = heights[i] * (rse[i] - lse[i] - 1);
            area = Math.max(area, currArea);
        }

        return area;
    }

    public static int[] rse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            res[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return res;
    }

    public static int[] lse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return res;
    }
}
