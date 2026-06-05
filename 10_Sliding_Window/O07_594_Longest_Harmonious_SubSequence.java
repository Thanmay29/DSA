package Sliding_Window;


//You're given an array of integers.
// Your task is to find the length of the longest harmonious subsequence from that array.

//🔍 What is a Harmonious Subsequence?
//A harmonious subsequence is a subsequence where:
//The difference between the maximum and minimum elements is exactly 1.

//Input: [1, 3, 2, 2, 5, 2, 3, 7]
//OutPut: [3, 2, 2, 2, 3] = len = 5
//Maximum = 3
//Minimum = 2
//Difference = 3 - 2 = 1 ✅

//Length of this subsequence = 5
//So, output = 5

// Explanation:
//Count the frequency of each element using a HashMap.
//For each key, check if key + 1 exists in the map.
//If it does, that means they can form a harmonious subsequence,
// and their combined frequency is a candidate for the longest such subsequence.
//Return the maximum such length.

import java.util.HashMap;

public class O07_594_Longest_Harmonious_SubSequence {

    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check for harmonious subsequence
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 1};

        System.out.println("Output for nums1: " + findLHS(nums1)); // Expected: 5
        System.out.println("Output for nums2: " + findLHS(nums2)); // Expected: 2
        System.out.println("Output for nums3: " + findLHS(nums3)); // Expected: 0
    }
}
