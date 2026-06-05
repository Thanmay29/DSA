package Stack.Monotonic_Stack;

import java.util.Stack;

public class O08_2104_Sum_Of_SubArray_Range {

    public static long optimal(int[] nums) {
        return max(nums) - min(nums);
    }

    public static long min(int[] nums){
        int n = nums.length;
        long sum = 0L;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n || nums[i] <= nums[st.peek()])){
                int mid = st.pop();
                int left = st.isEmpty() ? mid+1 : mid-st.peek();
                int right = i-mid;

                sum+=(long)nums[mid] * left * right;
            }
            if(i<n) st.push(i);
        }

        return sum;
    }

    public static long max(int[] nums){
        int n = nums.length;
        long sum = 0L;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<=n; i++){
            while(!st.isEmpty() && (i==n || nums[i] >= nums[st.peek()])){
                int mid = st.pop();
                int left = st.isEmpty() ? mid+1 : mid - st.peek();
                int right = i-mid;

                sum+=(long)nums[mid] * left * right;
            }
            if(i<n) st.push(i);
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        int[] nums1 = {4,-2,-3,4,1};
        System.out.println(brute(nums1));

        System.out.println(optimal(nums));
        System.out.println(optimal(nums1));
    }

    public static long brute(int[] nums){
        long sum = 0;

        for(int i=0; i<nums.length; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j=i; j< nums.length; j++){
                min= Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                sum+= (max-min);
            }
        }
        return sum;
    }
}
