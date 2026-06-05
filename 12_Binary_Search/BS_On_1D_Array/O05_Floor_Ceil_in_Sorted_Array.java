package Binary_Search.BS_On_1D_Array;

//Example 1
//Input : nums =[3, 4, 4, 7, 8, 10], x= 5  //Output: 4 7

//Explanation:
//  The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7

//Example 2
//Input : nums =[3, 4, 4, 7, 8, 10], x= 8   //Output: 8 8

import java.util.Arrays;

//Explanation:
//   The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
public class O05_Floor_Ceil_in_Sorted_Array {

    public static int[] getFloorAndCeil(int[] nums, int x) {
        int ceilIdx = lowerBound(nums, x);
        int ceil = (ceilIdx < nums.length) ? nums[ceilIdx] : -1;

        int floorIdx = upperBound(nums, x)-1;
        int floor = (floorIdx >= 0) ? nums[floorIdx] : -1;

        return new int[]{floor, ceil};
    }

    public static int lowerBound(int[] nums, int x){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] < x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    public static int upperBound(int[] nums, int x){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] <= x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    static void main() {


        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 5)));
        //op{4, 7}
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 8)));
        //op{8, 8}
    }
}
