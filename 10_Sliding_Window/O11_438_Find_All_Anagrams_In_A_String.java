package Sliding_Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O11_438_Find_All_Anagrams_In_A_String {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        // Initialize frequency of characters in p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int windowSize = p.length();

        // Initialize the first window
        for (int i = 0; i < windowSize; i++) {
            sFreq[s.charAt(i) - 'a']++;
        }

        // Compare first window
        if (Arrays.equals(pFreq, sFreq)) result.add(0);

        // Slide the window
        for (int i = windowSize; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++; // add new char
            sFreq[s.charAt(i - windowSize) - 'a']--; // remove old char

            if (Arrays.equals(pFreq, sFreq)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println("Input: s = \"" + s1 + "\", p = \"" + p1 + "\"");
        System.out.println("Output: " + findAnagrams(s1, p1));  // Expected: [0, 6]

        String s2 = "abab";
        String p2 = "ab";
        System.out.println("Input: s = \"" + s2 + "\", p = \"" + p2 + "\"");
        System.out.println("Output: " + findAnagrams(s2, p2));  // Expected: [0, 1, 2]
    }
}
