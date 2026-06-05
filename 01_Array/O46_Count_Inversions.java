package Array;

public class O46_Count_Inversions {

//    Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
//    It indicates how close an array is to being sorted.
//    A sorted array has an inversion count of 0.
//    An array sorted in descending order has maximum inversion.

    public static int numberOfInversions(int[] nums) {
        int count = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]>nums[j] && i<j){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};
        System.out.println(numberOfInversions(nums));
//        Output: 5
//        Explanation: The responsible indexes are:
//        nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3
//        nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3
//        nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3
//        nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4
//        nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5

        int[] nums1 = {-10, -5, 6, 11, 15, 17};
        System.out.println(numberOfInversions(nums1));
//        Output:
//        Explanation: nums is sorted, hence no inversions present.
    }
}
