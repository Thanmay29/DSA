package HashMap_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O06_442_Find_All_Duplicates_In_An_Array {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i< nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]<0) res.add(Math.abs(nums[i]));
            nums[idx] = -nums[idx];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {4,3,2,7,8,2,3,1};
        System.out.println("Output: " + findDuplicates(nums1)); //Output: [2,3]

        int[] nums2 = {1,1,2};
        System.out.println("Output: " + findDuplicates(nums2)); //[1]

        int[] nums3 = {1};
        System.out.println("Output: " + findDuplicates(nums3)); //[]
    }
}
