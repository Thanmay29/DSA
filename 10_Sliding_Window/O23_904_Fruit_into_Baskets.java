package Sliding_Window;

import java.util.HashMap;

public class O23_904_Fruit_into_Baskets {

    public static int totalFruit(int[] fruits) {
        // map: fruit type -> how many of that type are currently in the window [left, right]
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, len = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Step 1: pick fruit at tree 'right' and add it to the basket-count map
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // Step 2: if we now have more than 2 distinct fruit types (baskets),
            // we can't hold this window -> shrink from the left until valid again
            while (map.size() > 2) {
                map.put(fruits[left], map.getOrDefault(fruits[left], 0) - 1);

                // if a fruit type's count drops to 0, it's no longer in the window,
                // so remove it from the map entirely (frees up a "basket slot")
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            // Step 3: window [left, right] is guaranteed valid (<=2 distinct types) here,
            // so record its size if it's the best one so far
            len = Math.max(len, right - left + 1);
        }

        return len;
    }

    public static void main(String[] args) {
        int[] fruits1 = {1, 2, 1};
        System.out.println("Output: " + totalFruit(fruits1)); // Expected: 3

        int[] fruits2 = {0, 1, 2, 2};
        System.out.println("Output: " + totalFruit(fruits2)); // Expected: 3

        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println("Output: " + totalFruit(fruits3)); // Expected: 4
    }
}