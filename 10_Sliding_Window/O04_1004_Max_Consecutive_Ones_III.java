package Sliding_Window;

public class O04_1004_Max_Consecutive_Ones_III {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeroCount = 0;

        for(int right = 0; right< nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }

            while(zeroCount>k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
