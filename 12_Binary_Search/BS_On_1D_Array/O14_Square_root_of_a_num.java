package Binary_Search.BS_On_1D_Array;

public class O14_Square_root_of_a_num {

    public static int floorSqrt(int n) {
        int left = 1, right = n;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= n) {
                ans = mid;        // mid is valid, try for a bigger one
                left = mid + 1;
            } else {
                right = mid - 1;  // mid too big, search smaller
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(36)); // Output: 6
        System.out.println(floorSqrt(28)); // Output: 5
        System.out.println(floorSqrt(50)); // Output: 7
        System.out.println(floorSqrt(1));  // Output: 1
    }
}