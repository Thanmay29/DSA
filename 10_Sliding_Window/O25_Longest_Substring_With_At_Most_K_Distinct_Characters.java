package Sliding_Window;

import java.util.HashMap;

public class O25_Longest_Substring_With_At_Most_K_Distinct_Characters {

    public int kDistinctChar(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, len = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            len = Math.max(len, right - left + 1);
        }

        return len;
    }

    public static void main(String[] args) {
        O25_Longest_Substring_With_At_Most_K_Distinct_Characters sol =
                new O25_Longest_Substring_With_At_Most_K_Distinct_Characters();

        System.out.println(sol.kDistinctChar("aababbcaacc", 2)); // 6
        System.out.println(sol.kDistinctChar("abcddefg", 3));    // 4
    }
}