package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O35_349_Rearrange_Array_Elements_By_Sign {

//    nums consists of equal number of positive and negative integers.
    static int[] rearrangeArray(int[] nums){

        int n = nums.length;
        int[] ans = new int[n];

        int posIndex = 0;
        int negIndex = 1;
        for(int  i = 0 ; i < n ; i++){
            if(nums[i] < 0){
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
            else{
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return ans;

//        Other Solution

//        List<Integer> pos = new ArrayList<>();
//        List<Integer> neg = new ArrayList<>();
//
//        // Separate positive and negative numbers
//        for (int num : nums) {
//            if (num > 0)
//                pos.add(num);
//            else
//                neg.add(num);
//        }
//
//        int idx = 0, p = 0, n = 0;
//        // Alternate placement
//        while(idx<nums.length){
//            nums[idx++] = pos.get(p++);
//            nums[idx++] = neg.get(n++);
//        }
//
//        return nums;

    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
//        Output: [3,-2,1,-5,2,-4]
    }
}
