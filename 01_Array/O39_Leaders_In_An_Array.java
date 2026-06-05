package Array;

//A leader in an array is an element whose value is strictly greater than
// all elements to its right in the given array.
//he rightmost element is always a leader.
// The elements in the leader array must appear in the order they appear in the nums array.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Input: nums = [1, 2, 5, 3, 1, 2]
//
//Output: [5, 3, 2]
//
//Explanation: 2 is the rightmost element,
// 3 is the largest element in the index range [3, 5],
// 5 is the largest element in the index range [2, 5]
public class O39_Leaders_In_An_Array {

    public static ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        int maxRight = Integer.MIN_VALUE;

        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]>maxRight){
                list.add(nums[i]);
                maxRight = nums[i];
            }
        }

        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 1, 2};
        System.out.println(leaders(nums)); // Output: [5, 3, 2]
    }
}
