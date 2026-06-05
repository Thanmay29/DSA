package HashMap_Set;

import java.util.HashMap;
import java.util.Map;

public class O05_1248_Count_Number_Of_Nice_Subarrays {
    public static void main(String[] args){
        int[] nums1 = {1,1,2,1,1};
        int k1 = 3; //Output: 2
        //Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
        System.out.println(sol(nums1, k1));

        int[] nums2 = {2,4,6};
        int k2 = 1; //Output: 0
        //Explanation: There are no odd numbers in the array.
        System.out.println(sol(nums2, k2));

        int[] nums3 = {2,2,2,1,2,2,1,2,2,2};
        int k3 = 2; //Output: 16
        System.out.println(sol(nums3, k3));
    }

    public static int sol(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int oddCount = 0;
        int count = 0;

        for(int num : nums){
            if(num%2 != 0) oddCount++;

            count+=map.getOrDefault(oddCount-k, 0);
            map.put(oddCount, map.getOrDefault(oddCount, 0)+1);
        }

        return count;
    }
}
