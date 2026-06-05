package Prefix_Sum_Suffix_Kadane;

public class O02_724_Find_Pivot_Index {
    public static void main(String[] args) {

        //Input: nums = [1,7,3,6,5,6]
        //Output: 3
        //Explanation:
        //The pivot index is 3.
        //Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        //Right sum = nums[4] + nums[5] = 5 + 6 = 11
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int left = 0, totalSum = 0;

        for(int num : nums){
            totalSum+=num;
        }

        for(int i=0; i<nums.length; i++){
            if(left == totalSum-left-nums[i]){
                return i;
            }
            left += nums[i];
        }

        return -1;
    }
}
