package Sliding_Window;

public class O18_Longest_Subarray_with_Sum_k_Positive_elements {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15; // 4

        int ans = longestSubarray(nums, k);
        System.out.println(ans);

        int[] nums1 = {1, 2, 1};
        int k1 = 6;// -1

        int ans1 = longestSubarray(nums1, k1);
        System.out.println(ans1);
    }

    public static int longestSubarray(int[] nums, int k){
        int n = nums.length;
        int l=0, r=0;
        int sum=0, len = 0;

        while(r<n){
            sum+=nums[r];

            while(sum>k && l<=r){
                sum-=nums[l];
                l++;
            }

            if(sum==k){
                len = Math.max(len, r-l+1);
            }

            r++;
        }

        return len>0 ? len : -1;
    }
}
