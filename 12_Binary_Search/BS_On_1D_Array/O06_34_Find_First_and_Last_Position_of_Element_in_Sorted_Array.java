package Binary_Search.BS_On_1D_Array;

//Example 1:
//Input: nums = [5,7,7,8,8,10], target = 8  //Output: [3,4]

//Example 2:
//Input: nums = [5,7,7,8,8,10], target = 6  //Output: [-1,-1]

//Example 3:
//Input: nums = [], target = 0  //Output: [-1,-1]

import java.util.Arrays;

public class O06_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;;

        if(n==0) return new int[]{-1, -1};

        int first = lowerBound(nums, target);

        if(first == n || nums[first] != target){
            return new int[]{-1, -1};
        }

        int last = upperBound(nums, target)-1;

        return new int[]{first, last};
    }

    public static int lowerBound(int[] nums, int tar){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] < tar) left = mid +1;
            else right = mid;
        }

        return left;
    }

    public static int upperBound(int[] nums, int tar){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] <= tar) left = mid +1;
            else right = mid;
        }

        return left;
    }

    static void main() {

        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        //Output: [3,4]
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
        //Output: [-1,-1]
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
        //Output: [-1,-1]
    }
}
