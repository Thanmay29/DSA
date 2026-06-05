package Array;

import java.util.HashSet;

public class O31_Union_Of_Two_Arrays {

//    static int[] union(int[] nums, int[] nums1){
//        int[] num = new
//    }

    static HashSet<Integer> unionSet(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums1) set.add(n);
        for(int n : nums2) set.add(n);

        return set;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 7};
        HashSet<Integer> res = unionSet(nums1, nums2);
        System.out.println(res);
    }
}
