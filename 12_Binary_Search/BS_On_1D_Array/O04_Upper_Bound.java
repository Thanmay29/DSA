package Binary_Search.BS_On_1D_Array;

public class O04_Upper_Bound {

    // Returns index of first element > x
    //floor is the largest element less than or equal to x
    public static int upperBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length; // exclusive
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= x) { // note <= instead of <
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        System.out.println(upperBound(arr1, 2)); // Output: 3

        int[] arr2 = {3, 5, 8, 15, 19};
        System.out.println(upperBound(arr2, 9)); // Output: 3
    }
}

