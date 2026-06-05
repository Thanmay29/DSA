package HashMap_Set;

import java.util.HashMap;
import java.util.HashSet;

public class O02_1207_Unique_Number_Of_Occurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};

        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        return map.size()== set.size();
    }
}
