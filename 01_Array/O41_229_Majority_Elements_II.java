package Array;

//Given an integer array of size n,
// find all elements that appear more than ⌊ n/3 ⌋ times.

//Example 1:
//Input: nums = [3,2,3]
//Output: [3]

//Example 2:
//Input: nums = [1]
//Output: [1]

//Example 3:
//Input: nums = [1,2]
//Output: [1,2]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class O41_229_Majority_Elements_II {

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int threshold = nums.length/3;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key) > threshold){
                res.add(key);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement(nums1)); // [3]

        int[] nums2 = {1};
        System.out.println(majorityElement(nums2)); // [1]

        int[] nums3 = {1, 2};
        System.out.println(majorityElement(nums3)); // [1, 2]
    }
}
