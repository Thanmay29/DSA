package Array;

import java.util.*;

public class O45_Find_The_Repeating_And_Missing_Number {

    public static int[] findMissingRepeatingNumbers(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int repeating = -1;

        int actualSum = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                repeating = num;  // found repeating number
            }
            set.add(num);
            actualSum += num;
        }

        int n = nums.length;
        int totalSum = n * (n + 1) / 2;

        int missing = totalSum - (actualSum - repeating);

        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 1};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(nums)));
//        Output: [1, 2]
//        Explanation: 1 appears two times in the array and
//                      2 is missing from nums

        int[] nums1 = {1, 2, 3, 6, 7, 5, 7};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(nums1)));
//        Output: [7, 4]
//        Explanation: 7 appears two times in the array
//                      and 4 is missing from nums.
    }
}
