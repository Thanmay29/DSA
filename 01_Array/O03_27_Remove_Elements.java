package Array;

public class O03_27_Remove_Elements {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3};
        int val = 3;
        System.out.println(sol(nums, val));
    }

    public static int sol(int[] nums, int val){
        if(nums==null || nums.length==0) return 0;

        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
