package Stack.Monotonic_Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class O11_Number_Of_Greater_Elements_to_the_Right {

//    public static List<Integer> count_NGE(int[] arr, int[] indices) {
//        // Your code goes here
//
//    }

    public static List<Integer>  brute(int[] arr, int[] indices) {
        // Your code goes here
        int len = indices.length;
        List<Integer> list = new ArrayList<>();

        int n = 0;
        while(n<len){
            Stack<Integer> st = new Stack<>();

            int idx = indices[n];
            int val = arr[idx];

            for(int i=idx; i< arr.length; i++){
                if(arr[i]>val){
                    st.push(arr[i]);
                }
            }
            list.add(st.size());
            n++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices1 = {0, 5};
        System.out.println(brute(arr1, indices1));//Output: [6, 1]
        //System.out.println(count_NGE(arr1, indices1));//Output: [6, 1]
        //Explanation:
        //For index 0 → arr[0] = 3,
            // elements greater than 3 to its right are [4, 7, 5, 8, 10, 6] → count = 6.
        //For index 5 → arr[5] = 8,
            // greater elements to the right are [10] → count = 1.

        int[] arr2 = {1, 2, 3, 4, 1};
        int[] indices2 = {0, 3};
        System.out.println(brute(arr2, indices2));//Output: [6, 1]
        //System.out.println(count_NGE(arr2, indices2)); //Output: [3, 0]
        //Explanation:
        //For index 0 → arr[0] = 1,
            // greater elements to the right are [2, 3, 4] → count = 3.
        //For index 3 → arr[3] = 4,
            // no elements greater than 4 exist to the right → count = 0.
    }

}
