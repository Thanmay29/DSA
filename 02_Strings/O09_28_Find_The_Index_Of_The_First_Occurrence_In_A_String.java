package Strings;

public class O09_28_Find_The_Index_Of_The_First_Occurrence_In_A_String {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(strStr(haystack, needle));
    }

//best solution

class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] lps = buildLPS(needle);

        int i = 0; // haystack pointer
        int j = 0; // needle pointer

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j; // match found
                }

            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    // Build LPS array
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}


    public static int strStr(String haystack, String needle) {
        int m =haystack.length(), n = needle.length();

        for(int i=0; i<=m-n; i++){
            if(haystack.substring(i, i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
