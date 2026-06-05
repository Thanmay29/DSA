package Strings;

public class o14_392_Is_Subsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";

        // (i.e., "ace" is a subsequence of "abcde" while "aec" is not)
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Move in s
            }
            j++; // Always move in t
        }

        return i == s.length(); // If we matched all characters of s, return true
    }
}
