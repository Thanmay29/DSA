package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class O12_345_Reverse_Vowels_Of_A_String {
    public static void main(String[] args) {
        String s = "IceCreAm";
        //Output: "AceCreIm"

        //Explanation:
        //The vowels in s are ['I', 'e', 'e', 'A'].
        // On reversing the vowels, s becomes "AceCreIm".

        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(arr[left])) {
                left++; // Move left forward
            }
            while (left < right && !vowels.contains(arr[right])) {
                right--; // Move right backward
            }

            if (left < right) {
                // Swap vowels
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // Move pointers
                left++;
                right--;
            }
        }

        return new String(arr);
    }
}
