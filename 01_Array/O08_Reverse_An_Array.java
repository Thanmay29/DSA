package Array;

public class O08_Reverse_An_Array {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        sol(nums);
        for(int num : nums){
            System.out.print(num+" ");
        }
    }

    public static void sol(int[] nums){
        int left = 0, right = nums.length-1;

        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
