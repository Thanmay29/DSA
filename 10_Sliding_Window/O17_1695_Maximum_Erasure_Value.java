package Sliding_Window;

import java.util.HashSet;
import java.util.Set;

public class O17_1695_Maximum_Erasure_Value {

//    You're given an array of positive integers,
//    and you can erase one subarray (a slice of consecutive elements)
//    that has only unique (non-repeating) numbers.
//You earn a score equal to the sum of the numbers in that subarray.
//
//You need to find the subarray with unique elements that gives you the maximum score (sum).

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int n = nums.length;
        int sum = 0, maxSum = 0;

        while(right<n){
            if(!set.contains(nums[right])){
                set.add(nums[right]);
                sum+=nums[right];
                maxSum = Math.max(maxSum,sum);
                right++;
            }else{
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {4,2,4,5,6};//output 17
        int[] nums1 = {5,2,1,2,5,2,1,2,5};//output 8

        System.out.println(maximumUniqueSubarray(nums1));
    }
}
