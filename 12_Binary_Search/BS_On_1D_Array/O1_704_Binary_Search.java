package Binary_Search.BS_On_1D_Array;

public class O1_704_Binary_Search {

//    Given an array of integers nums which is sorted in ascending order,
//    and an integer target,
//    write a function to search target in nums.
//    If target exists, then return its index.
//    Otherwise, return -1
    public static int search(int[] nums, int target) {

        //optimal in 0ms
        int left = 0, right = nums.length-1;

        while(left<=right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                return mid;
            }if(nums[mid] < target){
                left = mid+1;;
            }else{
                right = mid-1;
            }
        }

        return -1;

        //optimal but runs in 2ms
//        int left = 0, right = nums.length;
//
//        while(left<right){
//            int mid = left+(right-left)/2;
//
//            if(nums[mid] == target){
//                return mid;
//            }else if(nums[mid] < target){
//                left++;
//            }else{
//                right--;
//            }
//        }
//
//        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
        //output = 4

        int[] nums1 = {-1,0,3,5,9,12};
        int target1 = 2;
        System.out.println(search(nums1, target1));
        //output = -1 \\becaus 2 does not exist in the array
    }
}
