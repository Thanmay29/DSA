package Array;

import java.util.Arrays;
import java.util.HashMap;

public class O43_Largest_Subarray_With_Sum_0 {

//    You are given an integer array arr of size n
//    which contains both positive and negative integers.
//    Your task is to find the length of the longest contiguous subarray with sum equal to 0.

//Return the length of such a subarray.
// If no such subarray exists, return 0.

    public static int maxLen(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxlen = 0;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            if(sum == 0){
                maxlen = i+1;// subarray from start
            }

            if(map.containsKey(sum)){
                maxlen = Math.max(maxlen, i-map.get(sum));
            }else{
                map.put(sum, i);// store first occurrence
            }
        }

        return maxlen;
    }

//Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]
//Output: 5
//Explanation:
//The subarray [-2, 2, -8, 1, 7]
//sums up to 0 and has the maximum length among all such subarrays.
    public static void main(String[] args) {
        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr1)); // Output: 5

        int[] arr2 = {2, 10, 4};
        System.out.println(maxLen(arr2)); // Output: 0
    }
}

//
