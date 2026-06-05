package Array;

import java.util.Arrays;

public class O23_238_Product_Of_Array_Expect_Self {
    public static void main(String[] args) {
        int[] nums = {1 ,2, 3, 4};
        //output = [24,12,8,6]

        //Example 2:
        //
        //Input: nums = [-1,1,0,-3,3]
        //Output: [0,0,9,0,0]

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Compute prefix products
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        //[1, 1, 2, 6]

        // Step 2: Compute suffix products and update res array
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i]; // Update suffix product
        }
//        [24,12,8,6]

        return res;
    }

    //Not optimal takes o(n^2)
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//
//        for(int i=0; i<n; i++){
//            int left= i-1, right = i+1;
//            int leftProduct = 1, rightProduct = 1;
//
//                while(left>=0){
//                    leftProduct = leftProduct * nums[left--];
//                }
//
//
//                while(right<=n-1){
//                    rightProduct = rightProduct * nums[right++];
//                }
//
//            res[i] = rightProduct * leftProduct;
//
//
//        }
//
//        return res;
//    }
}
