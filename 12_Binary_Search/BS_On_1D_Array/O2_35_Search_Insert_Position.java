package Binary_Search.BS_On_1D_Array;

public class O2_35_Search_Insert_Position {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println(sol(nums, target));
    }

//    Given a sorted array of distinct integers and a target value,
//    return the index if the target is found.
//    If not, return the index where it would be if it were inserted in order.
    public static int sol(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+ (right-left)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
