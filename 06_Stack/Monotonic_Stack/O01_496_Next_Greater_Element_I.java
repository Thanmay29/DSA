package Stack.Monotonic_Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class O01_496_Next_Greater_Element_I {

    //Easier sol

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i = nums2.length-1; i>=0; i--){
            while(!st.isEmpty() && nums2[i] >= st.peek()){
                st.pop();
            }

            map.put(nums2[i], st.isEmpty() ? -1 : st.peek());
            st.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        // Map to store the next greater element for each number in nums2
//        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
//        Stack<Integer> stack = new Stack<>();
//
//        // Traverse nums2
//        for (int num : nums2) {
//            // While current num is greater than stack top, it's the next greater
//            while (!stack.isEmpty() && num > stack.peek()) {
//                nextGreaterMap.put(stack.pop(), num);
//            }
//            stack.push(num);
//        }
//
//        // For remaining elements in stack, no next greater exists
//        while (!stack.isEmpty()) {
//            nextGreaterMap.put(stack.pop(), -1);
//        }
//
//        // Create result for nums1 based on the map
//        int[] res = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            res[i] = nextGreaterMap.get(nums1[i]);
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]
    }
}
