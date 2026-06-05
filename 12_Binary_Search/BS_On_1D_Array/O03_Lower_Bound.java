package Binary_Search.BS_On_1D_Array;

//Example 1
//Input : nums= [1,2,2,3], x = 2   //Output:1

//Explanation:
//Index 1 is the smallest index such that arr[1] >= x.

//Example 2
//Input : nums= [3,5,8,15,19], x = 9  //Output: 3

//Explanation:
//Index 3 is the smallest index such that arr[3] >= x.
public class O03_Lower_Bound {

    //ceil is the first element greater than or equal to x
    public static int lowerBound(int[] nums, int x) {
        int n = nums.length;

        int left = 0, right = n;

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

    static void main() {
        System.out.println(lowerBound(new int[]{1, 2, 2, 3}, 2));//Output:1
        System.out.println(lowerBound(new int[]{3,5,8,15,19}, 9));//Output: 3
    }
}
