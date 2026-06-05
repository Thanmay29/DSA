package Strings;

public class O09_28_Find_The_Index_Of_The_First_Occurrence_In_A_String {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(strStr(haystack, needle));
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
