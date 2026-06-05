package Stack.Monotonic_Stack;

//Problem:
// For each day, find how many days to wait for a warmer temperature.

//Input: T = [73,74,75,71,69,72,76,73]

//Output: [1,1,4,2,1,1,0,0]

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class O14_739_Daily_Temperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                res[idx] = i-idx;
            }
            st.push(i);
        }
        return res;
    }

    static void main() {

        int[] t = {73,74,75,71,69,72,76,73};//Output: [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(t)));

    }
}
