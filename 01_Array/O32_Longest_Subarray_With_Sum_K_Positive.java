package Array;

public class O32_Longest_Subarray_With_Sum_K_Positive {

    public static int res(int[] nums, int k){
        int left = 0;
        int len = 0;
        int sum = 0;

        for(int right = 0; right< nums.length; right++){

            sum+=nums[right];

            if(sum>k && left<=right){
                sum-=nums[left];
                left++;
            }

            if(sum==k){
                len = Math.max(len, right-left+1);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int ans = res(nums, k);
        System.out.println(ans);
    }
}
