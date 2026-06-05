package HashMap_Set;

import java.util.*;

public class O03_1657_Determine_If_Two_Strings_Are_Close {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";

        System.out.println(closeStrings(word1, word2));
    }
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // Step 1: Frequency map for each word
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        // Step 2: Check if both words have the same unique characters
        if (!freq1.keySet().equals(freq2.keySet())) return false;

        // Step 3: Check if frequency distributions are the same
        List<Integer> values1 = new ArrayList<>(freq1.values());
        List<Integer> values2 = new ArrayList<>(freq2.values());
        Collections.sort(values1);
        Collections.sort(values2);

        return values1.equals(values2);
    }
}
