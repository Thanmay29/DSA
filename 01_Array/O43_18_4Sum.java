package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O43_18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length<4){
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates for i

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates for j

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++; // skip dup left
                        while (left < right && nums[right] == nums[right - 1]) right--; // skip dup right

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        O43_18_4Sum obj = new O43_18_4Sum();
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        System.out.println(obj.fourSum(nums1, 0));
        // Expected: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(obj.fourSum(nums2, 8));
        // Expected: [[2, 2, 2, 2]]
    }
}
