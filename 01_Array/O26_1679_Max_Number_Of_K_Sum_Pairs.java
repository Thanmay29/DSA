package Array;

import java.util.Arrays;

public class O26_1679_Max_Number_Of_K_Sum_Pairs {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 5;
        //output = 2;

        //Explanation: Starting with nums = [1,2,3,4]:
        //- Remove numbers 1 and 4, then nums = [2,3]
        //- Remove numbers 2 and 3, then nums = []
        //There are no more pairs that sum up to 5, hence a total of 2 operations.

        //Example 2:
        //Input: nums = [3,1,3,4,3], k = 6
        //Output: 1
        //Explanation: Starting with nums = [3,1,3,4,3]:
        //- Remove the first two 3's, then nums = [1,4,3]
        //There are no more pairs that sum up to 6, hence a total of 1 operation.
        O26_1679_Max_Number_Of_K_Sum_Pairs obj = new O26_1679_Max_Number_Of_K_Sum_Pairs();
        int res = obj.maxOperations(nums, k);
        System.out.println(res);
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int l = 0, r = nums.length - 1;
        int count = 0;

        while (l < r) {
            int sum = nums[l] + nums[r];

            if (sum == k) {  // Found a valid pair
                count++;
                l++;
                r--;
            } else if (sum < k) {
                l++;  // Need a larger sum, move left pointer
            } else {
                r--;  // Need a smaller sum, move right pointer
            }
        }

        return count;
    }
}
