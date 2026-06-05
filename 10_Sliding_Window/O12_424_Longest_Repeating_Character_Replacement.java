package Sliding_Window;

public class O12_424_Longest_Repeating_Character_Replacement {

    public static int characterReplacement(String s, int k) {
        int left = 0, maxCount = 0, len = 0;
        int[] count = new int[26]; // To count frequency of characters in current window

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++; // Increment frequency of current character
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']); // Update maxFreq

            // If the number of characters to change > k, shrink the window
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the max length of valid window
            len = Math.max(len, right - left + 1);
        }

        return len;
    }

    public static void main(String[] args) {
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: " + characterReplacement(s1, k1)); // Output: 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: " + characterReplacement(s2, k2)); // Output: 4
    }
}
