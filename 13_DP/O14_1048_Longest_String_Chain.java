package DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class O14_1048_Longest_String_Chain {
    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};

        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words){
        Arrays.sort(words, Comparator.comparingInt(String::length)); // Step 1: Sort words by length

        Map<String, Integer> dp = new HashMap<>(); // Store longest chain ending at each word
        int maxLength = 1; // Minimum chain length is 1 (each word itself)

        for (String word : words) {
            int bestChain = 1;
            for (int i = 0; i < word.length(); i++) { // Try removing each character
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    bestChain = Math.max(bestChain, dp.get(predecessor) + 1);
                }
            }
            dp.put(word, bestChain); // Store the best chain length for this word
            maxLength = Math.max(maxLength, bestChain); // Track the longest chain found
        }

        return maxLength;
    }
}
