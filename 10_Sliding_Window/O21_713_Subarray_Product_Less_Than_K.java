package Sliding_Window;

public class O21_713_Subarray_Product_Less_Than_K {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        System.out.println(sol(nums, k));//8
    }

    public static int sol(int[] nums, int k){
        int count = 0;
        int left = 0;
        long product = 1;

        for(int right = 0; right< nums.length; right++){
            product*=nums[right];

            while(product>=k){
                product/=nums[left];
                left++;
            }

            count+=(right-left+1);
        }
        return count;
    }
}
