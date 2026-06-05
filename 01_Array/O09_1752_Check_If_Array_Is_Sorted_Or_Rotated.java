package Array;

public class O09_1752_Check_If_Array_Is_Sorted_Or_Rotated {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};//true
//        int[] nums = {3, 2, 1, 2};//false
        System.out.println(sol(nums));
    }

    public static boolean sol(int[] nums){
        int count = 0, n = nums.length;

        for (int i = 0; i < n; i++) {

            //We compare nums[i] with nums[i + 1],
            // using modulus (% n) to handle the circular rotation.
            //If nums[i] > nums[(i + 1) % n], it means the order is broken.

            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
