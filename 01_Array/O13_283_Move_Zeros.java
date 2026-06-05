package Array;

import java.util.Arrays;

public class O13_283_Move_Zeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums){
        int zeros= 0;

        for(int num : nums){
            if(num!=0){
                nums[zeros++] = num;
            }
        }

        while(zeros<nums.length){
            nums[zeros++] = 0;
        }
    }
}
