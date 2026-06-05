package Sliding_Window;

import java.util.HashMap;

public class O20_340_Longest_Subarray_with_At_Most_K_Distinct_Integers {
    public static void main(String[] args){
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println(sol(nums, k));//4
    }

    public static int sol(int[] nums, int k){
        int left = 0;
        int n = nums.length;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right<n; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(map.size()>k){
                map.put(nums[left], map.getOrDefault(nums[left], 0)-1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            len = Math.max(len, right-left+1);
        }
        return len;
    }
}
