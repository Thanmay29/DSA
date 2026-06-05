package Binary_Search.BS_On_1D_Array;

public class O08_33_Search_in_Rotated_Sorted_Array {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    static void main() {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));//op : 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));//op : -1
        System.out.println(search(new int[]{1}, 0));//op : -1
    }
}
