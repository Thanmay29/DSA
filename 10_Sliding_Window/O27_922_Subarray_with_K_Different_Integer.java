package Sliding_Window;

import java.util.HashMap;

public class O27_922_Subarray_with_K_Different_Integer {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public static int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, len = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            len += right - left + 1;
        }

        return len;
    }

    public static void main(String[] args) {
        O27_922_Subarray_with_K_Different_Integer sol = new O27_922_Subarray_with_K_Different_Integer();

        int[] nums1 = {1, 2, 1, 2, 3};
        System.out.println(sol.subarraysWithKDistinct(nums1, 2)); // 7

        int[] nums2 = {1, 2, 1, 3, 4};
        System.out.println(sol.subarraysWithKDistinct(nums2, 3)); // 3
    }
}