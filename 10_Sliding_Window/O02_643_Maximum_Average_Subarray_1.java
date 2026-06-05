package Sliding_Window;

public class O02_643_Maximum_Average_Subarray_1 {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int currSum = 0;

        for(int i=0; i<k; i++){
            currSum+=nums[i];
        }

        int maxSum = currSum;

        for(int i=k; i< nums.length; i++){
            currSum = currSum - nums[i-k] + nums[i];

            maxSum = Math.max(maxSum, currSum);
        }

        return (double) maxSum/k;
    }
}
