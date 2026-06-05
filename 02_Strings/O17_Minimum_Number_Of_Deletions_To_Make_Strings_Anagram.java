package Strings;

public class O17_Minimum_Number_Of_Deletions_To_Make_Strings_Anagram {

    // This method calculates the minimum number of deletions required
    // to make two strings anagrams of each other
    public static int makeAnagram(String s1, String s2) {
        // Create a frequency array for all lowercase letters (a-z)
        int[] freq = new int[26];

        // Increase frequency for each character in s1
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++; // Example: 'c' - 'a' = 2 → freq[2]++
        }

        // Decrease frequency for each character in s2
        for (char ch : s2.toCharArray()) {
            freq[ch - 'a']--; // If same letter as in s1, it will cancel out (anagram behavior)
        }

        // Calculate the total number of deletions needed
        int count = 0;
        for (int c : freq) {
            // The absolute value gives the mismatch in counts between s1 and s2
            count += Math.abs(c); // e.g., freq['d'] = 1 means one extra 'd' in s1 → delete it
        }

        return count; // Total deletions required to make both strings anagrams
    }

    public static void main(String[] args) {
        String s1 = "cde";
        String s2 = "abc";
        // This should print 4, because 4 deletions are needed to make s1 and s2 anagrams
        System.out.println(makeAnagram(s1, s2)); // Output: 4
    }
}
