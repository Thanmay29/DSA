package Array;

import java.util.Arrays;

public class O07_1480_Running_Sum_Of_1D_Array {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sol(nums)));
    }

    public static int[] sol(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];

        for(int i=1; i<n; i++){
            res[i] = res[i-1] + nums[i];
        }

        return res;
    }
}
