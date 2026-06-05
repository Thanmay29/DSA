package Array;

import java.util.*;

public class O17_349_Intersection_Of_Two_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3};

        //Intersection_Of_Two_Arrays 1
        System.out.println("Output: "+ Arrays.toString((intersect_Unique_Element(nums1, nums2))));
        //Output: [2]

        //Intersection_Of_Two_Arrays 2
        System.out.println("Output: " + Arrays.toString(intersect(nums1, nums2)));
        // Output: [2, 2]
    }

    //Intersection_Of_Two_Arrays 1
    public static int[] intersect_Unique_Element(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check for common elements in nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert resultSet to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }

    //Intersection_Of_Two_Arrays 2
    public static int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int num : nums2){
            if(map.getOrDefault(num, 0)>0){
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}
