package Sliding_Window;

public class O05_1493_Longest_Subarray_Of_1s_After_Deleting_One_Element {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};

        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int zeroCount = 0, maxLen = 0, left = 0;

        for(int right = 0; right< nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }

            while(zeroCount>1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left);
        }

        return maxLen;
    }
}
