package HashMap_Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class O01_2215_Find_The_Difference_Of_Two_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int num : nums1) set1.add(num);
        for(int num : nums2) set2.add(num);

        List<Integer> unq1 = new ArrayList<>();
        for(int num : set1){
            if(!set2.contains(num)){
                unq1.add(num);
            }
        }

        List<Integer> unq2 = new ArrayList<>();
        for(int num : set2){
            if(!set1.contains(num)){
                unq2.add(num);
            }
        }

        return Arrays.asList(unq1, unq2);
    }
}
