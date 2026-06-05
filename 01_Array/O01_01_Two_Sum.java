package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class O01_01_Two_Sum {
    public static void main(String[] args) {
        int[] nums ={2, 7, 10, 5};
        int tar = 15;

        System.out.println(Arrays.toString(sol(nums, tar)));
        System.out.println(Arrays.toString(brute(nums, tar)));
    }

    public static int[] sol(int[] nums,int tar){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){

            int complement = tar - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }
//        throw  new IllegalArgumentException("No two sum solution");
        return new int[]{};
    }

    public static int[] brute(int[] nums, int tar){
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]+nums[j] == tar){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
