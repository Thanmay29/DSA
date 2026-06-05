package Array;

import java.util.HashMap;
import java.util.Map;

public class O44_Count_Subarray_With_Given_XOR_K {

    public static int subarraysWithXORK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // Important: XOR of empty prefix = 0

        int count = 0, prefixXor = 0;

        for (int num : nums) {
            prefixXor ^= num; // update prefix xor

            int target = prefixXor ^ k; // need prefixXor[l-1] = target

            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    //4 XOR 3 = 7
    //4 XOR 4 = 0

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println(subarraysWithXORK(nums1, k1)); // 4

        int[] nums2 = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println(subarraysWithXORK(nums2, k2)); // 2
    }
}
