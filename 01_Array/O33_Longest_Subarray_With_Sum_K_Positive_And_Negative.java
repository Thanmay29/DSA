package Array;

import java.util.HashMap;

public class O33_Longest_Subarray_With_Sum_K_Positive_And_Negative {

    public static int res(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Case 1: whole array from 0 to i adds up to k
            if (sum == k) {
                maxLen = i + 1;
            }

            // Case 2: if (sum - k) was seen before, subarray [previousIndex+1...i] sums to k
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Case 3: store the first occurrence of each prefix sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int ans = res(nums, k);
        System.out.println(ans);

        int[] nums2 = {-1, 2, 3};
        int K = 6;
        System.out.println(res(nums2, K));
    }
}
